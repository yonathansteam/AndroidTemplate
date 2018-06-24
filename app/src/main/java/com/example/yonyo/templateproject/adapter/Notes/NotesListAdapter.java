package com.example.yonyo.templateproject.adapter.Notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yonyo.templateproject.R;
import com.example.yonyo.templateproject.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NotesListViewHolder> {

    private Context context;
    private List<Note> notes;

    public NotesListAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    public class NotesListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.note)
        TextView note;
        @BindView(R.id.dot)
        TextView dot;
        @BindView(R.id.timestamp)
        TextView timestamp;

        public NotesListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindDataToView(Note myNote){
            note.setText(myNote.getNote());

            // Displaying dot from HTML character code
            dot.setText(Html.fromHtml("&#8226;"));

            // Formatting and displaying timestamp
            timestamp.setText(formatDate(myNote.getTimestamp()));
        }
    }

    @NonNull
    @Override
    public NotesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListViewHolder holder, int position) {
        holder.bindDataToView(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }


}
