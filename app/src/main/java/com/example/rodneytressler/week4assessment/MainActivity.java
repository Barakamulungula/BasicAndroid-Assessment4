package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;

    private List<Player> playerList;

    public static final String TAG = "PLAYER_LIST_TAG";

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {
        String name = nameInput.getText().toString();
        String team = teamInput.getText().toString();
        String playerNumber = numberInput.getText().toString();
        if(!name.isEmpty() && !team.isEmpty() && !playerNumber.isEmpty()){
            playerList.add(new Player(name,Integer.parseInt(playerNumber),team));
            Toast.makeText(this, "player added", Toast.LENGTH_SHORT).show();
            nameInput.setText("");
            teamInput.setText("");
            numberInput.setText("");
        }else{
            Toast.makeText(this, "All input fields required", Toast.LENGTH_SHORT).show();
        }

    }



    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {
        if(!playerList.isEmpty()){
            Intent intent = new Intent(MainActivity.this, PlayersActivity.class);
            intent.putParcelableArrayListExtra(TAG, (ArrayList<? extends Parcelable>) playerList);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Player list empty", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        playerList = new ArrayList<>();
    }


    
}
