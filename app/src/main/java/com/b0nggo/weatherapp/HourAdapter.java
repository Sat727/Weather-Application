package com.b0nggo.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.ViewHolder> {
    private List<HourData> hourDataList;

    public HourAdapter(List<HourData> hourDataList) {
        this.hourDataList = hourDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HourData data = hourDataList.get(position);
        holder.hourText.setText(data.getHour());
        holder.tempText.setText(data.getTemperature());
        holder.rainText.setText(data.getRainChance());
    }

    @Override
    public int getItemCount() {
        return hourDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView hourText, tempText, rainText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hourText = itemView.findViewById(R.id.hourText);
            tempText = itemView.findViewById(R.id.temperatureText);
            rainText = itemView.findViewById(R.id.rainText);
        }
    }
}