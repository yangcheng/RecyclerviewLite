package info.yangcheng.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by chengyang on 9/1/14.
 */
public class StringArrayAdapter extends RecyclerView.Adapter<StringArrayAdapter.ViewHolder>  {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.image_view)
        public ImageView imageView;
        @InjectView(R.id.text_view)
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }

    private ArrayList<String> mDataset;

    public void add(String item, int position) {
        mDataset.add(position,item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public StringArrayAdapter(List<String> dataSet){
        mDataset = new ArrayList<String>(dataSet);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(mDataset.get(i));

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
