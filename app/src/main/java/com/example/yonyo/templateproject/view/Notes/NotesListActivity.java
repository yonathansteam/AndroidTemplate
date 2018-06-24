package com.example.yonyo.templateproject.view.Notes;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonyo.templateproject.R;
import com.example.yonyo.templateproject.adapter.Notes.NotesListAdapter;
import com.example.yonyo.templateproject.database.DatabaseHelper;
import com.example.yonyo.templateproject.model.Note;
import com.example.yonyo.templateproject.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotesListActivity extends AppCompatActivity {

    @BindView(R.id.rv_notes_list)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private List<Note> notesList = new ArrayList<>();
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        ButterKnife.bind(this);

        db = new DatabaseHelper(this);

        setupRecyclerView();
    }

    private void setupRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        NotesListAdapter notesListAdapter = new NotesListAdapter(this, notesList);
        recyclerView.setAdapter(notesListAdapter);
    }

    @OnClick({R.id.fab})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fab:
                showNoteDialog(false, null, -1);
                break;
        }
    }


    private void showNoteDialog(final boolean shouldUpdate, final Note note, final int position) {
            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
            View view = layoutInflaterAndroid.inflate(R.layout.note_dialog, null);

            AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
            alertDialogBuilderUserInput.setView(view);

            final EditText inputNote = view.findViewById(R.id.note);
            TextView dialogTitle = view.findViewById(R.id.dialog_title);
            dialogTitle.setText(!shouldUpdate ? getString(R.string.lbl_new_note_title) : getString(R.string.lbl_edit_note_title));

            if (shouldUpdate && note != null) {
                inputNote.setText(note.getNote());
            }
            alertDialogBuilderUserInput
                    .setCancelable(false)
                    .setPositiveButton(shouldUpdate ? "update" : "save", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogBox, int id) {

                        }
                    })
                    .setNegativeButton("cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogBox, int id) {
                                    dialogBox.cancel();
                                }
                            });

            final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
            alertDialog.show();

//           alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // Show toast message when no text is entered
//                    if (TextUtils.isEmpty(inputNote.getText().toString())) {
//                        Toast.makeText(NotesListActivity.this, "Enter note!", Toast.LENGTH_SHORT).show();
//                        return;
//                    } else {
//                        alertDialog.dismiss();
//                    }
//
//                    // check if user updating note
//                    if (shouldUpdate && note != null) {
//                        // update note by it's id
//                        updateNote(inputNote.getText().toString(), position);
//                    } else {
//                        // create new note
//                        createNote(inputNote.getText().toString());
//                    }
//                }
//            });
        }

    private void createNote(String note) {
        // inserting note in db and getting
        // newly inserted note id
        long id = db.insertNote(note);

        // get the newly inserted note from db
        Note n = db.getNote(id);

        if (n != null) {
            // adding new note to array list at 0 position
            notesList.add(0, n);

            // refreshing the list
            mAdapter.notifyDataSetChanged();

            toggleEmptyNotes();
        }
    }

}
