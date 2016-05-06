package in.codehex.facilis.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import in.codehex.facilis.R;
import in.codehex.facilis.model.Members;

/**
 * Created by Codehex-Keshav on 05-05-2016.
 */
public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.MyViewHolder>{

    private List<Members> membersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView alphabetTextView, nameTextView, durationTextView, postedDateTextView, numberOfItemsTextView;

        public MyViewHolder(View view) {
            super(view);
            alphabetTextView = (TextView) view.findViewById(R.id.alphabet_text_view);
            nameTextView = (TextView) view.findViewById(R.id.name_text_view);
            durationTextView = (TextView) view.findViewById(R.id.duration_text_view);
            postedDateTextView = (TextView) view.findViewById(R.id.posted_date_text_view);
            numberOfItemsTextView = (TextView) view.findViewById(R.id.number_of_items_text_view);
        }
    }

    public MembersAdapter(List<Members> membersList){
        this.membersList = membersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Members members = membersList.get(position);
        String date, duration, numberOfItems, name, alphabet;
        date = members.getDate();
        duration = members.getDuration();
        numberOfItems = members.getNumberOfItems();
        name = members.getName();
        Random getRandomInteger = new Random();
        alphabet = name.substring(0,1);
        holder.alphabetTextView.setText(alphabet);
        holder.alphabetTextView.setBackgroundColor(Color.rgb( getRandomInteger.nextInt(256),
                getRandomInteger.nextInt(256),
                getRandomInteger.nextInt(256)));
        holder.nameTextView.setText(name);
        holder.numberOfItemsTextView.setText(numberOfItems);
        holder.durationTextView.setText(duration);
        holder.postedDateTextView.setText(date);



    }

    @Override
    public int getItemCount() {
        return membersList.size();
    }


}
