package org.aplas.makanannusantara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.aplas.makanannusantara.model.Makanan;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder>{
    Context context;

    private ArrayList<Makanan> listMakanan;

    public RecyclerViewAdapter(Context context,ArrayList<Makanan> listCard) {
        this.listMakanan = listCard;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.desain_layout_adapter, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.tvTitle.setText(listMakanan.get(position).getNama());
        Glide.with(context).asBitmap().load(listMakanan.get(position).getFoto()).into(holder.pict);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Intent intent = new Intent(context, DeatailActivity.class);
                intent.putExtra("foto_makanan", listMakanan.get(position).getFoto());
                intent.putExtra("nama_makanan", listMakanan.get(position).getNama());
                intent.putExtra("info_makanan", listMakanan.get(position).getInfo());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (listMakanan != null)? listMakanan.size() : 0;
    }

    void setFilter(ArrayList<Makanan> filterList){
        listMakanan = new ArrayList<>();
        listMakanan.addAll(filterList);
        notifyDataSetChanged();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CircleImageView pict;
        private TextView tvTitle;
        private ItemClickListener itemClickListener;
        private CardView cv;

        public CardViewHolder (View view){
            super(view);
            tvTitle = view.findViewById(R.id.textViewNamaMakanan);
            pict = view.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClickListener(view,getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
