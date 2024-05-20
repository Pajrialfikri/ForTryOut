package com.example.fortryout;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Context mContext;
    private List<Team> mTeamList;

    public TeamAdapter(Context context, List<Team> teamList) {
        mContext = context;
        mTeamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.team_item, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = mTeamList.get(position);
        holder.textTeamName.setText(team.getStrTeam());
        holder.textTeamId.setText("ID: " + team.getIdTeam()); // Set teks ID tim ke dalam TextView ID tim

        // Load team logo using Glide library
        Glide.with(mContext)
                .load(team.getStrTeamBadge())
                .into(holder.imageTeamLogo);
    }

    @Override
    public int getItemCount() {
        return mTeamList.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView textTeamName;
        TextView textTeamId; // Tambahkan referensi ke TextView untuk ID tim
        ImageView imageTeamLogo;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            textTeamName = itemView.findViewById(R.id.text_team_name);
            textTeamId = itemView.findViewById(R.id.text_team_id); // Inisialisasi TextView untuk ID tim
            imageTeamLogo = itemView.findViewById(R.id.image_team_logo);
        }
    }
}
