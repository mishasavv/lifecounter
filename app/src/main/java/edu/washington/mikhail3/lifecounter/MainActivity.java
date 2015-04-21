package edu.washington.mikhail3.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    int p1lives;
    int p2lives;
    int p3lives;
    int p4lives;
    int pLost;
    TextView p1liveText;
    TextView p2liveText;
    TextView p3liveText;
    TextView p4liveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1liveText = (TextView) findViewById(R.id.p1score);
        p2liveText = (TextView) findViewById(R.id.p2score);
        p3liveText = (TextView) findViewById(R.id.p3score);
        p4liveText = (TextView) findViewById(R.id.p4score);
        TextView lost = (TextView)findViewById((R.id.lost));
        if (savedInstanceState != null) {
            p1lives = savedInstanceState.getInt("p1");
            p2lives = savedInstanceState.getInt("p2");
            p3lives = savedInstanceState.getInt("p3");
            p4lives = savedInstanceState.getInt("p4");
            pLost = savedInstanceState.getInt("pLost");
        } else {
            p1lives = 20;
            p2lives = 20;
            p3lives = 20;
            p4lives = 20;
            pLost = 0;
        }
        p1liveText.setText(""+p1lives);
        p2liveText.setText("" + p2lives);
        p3liveText.setText(""+p3lives);
        p4liveText.setText(""+p4lives);
        if(pLost != 0){
            ifDead(pLost);
            if(p1lives <= 0){
                TextView p1lost = (TextView)findViewById((R.id.l1));
                p1lost.setVisibility(View.VISIBLE);
            } else if(p2lives <= 0){
                TextView p2lost = (TextView)findViewById((R.id.l2));
                p2lost.setVisibility(View.VISIBLE);
            } else if(p3lives <= 0){
                TextView p3lost = (TextView)findViewById((R.id.l3));
                p3lost.setVisibility(View.VISIBLE);
            } else if(p4lives <= 0){
                TextView p4lost = (TextView)findViewById((R.id.l4));
                p4lost.setVisibility(View.VISIBLE);
            }
        }
    }
    public void clickButton (View v) {
        TextView p1score = (TextView)findViewById((R.id.p1score));
        TextView p2score = (TextView)findViewById((R.id.p2score));
        TextView p3score = (TextView)findViewById((R.id.p3score));
        TextView p4score = (TextView)findViewById((R.id.p4score));
        if (v.getId() == R.id.p1m5){
            p1lives-=5;
            p1score.setText("" + p1lives);
            if(p1lives <= 0){
                TextView p1lost = (TextView)findViewById((R.id.l1));
                p1lost.setVisibility(View.VISIBLE);
                ifDead(1);
            }
        } else if (v.getId() == R.id.p1m1){
            p1lives-=1;
            p1score.setText("" + p1lives);
            if(p1lives <= 0){
                TextView p1lost = (TextView)findViewById((R.id.l1));
                p1lost.setVisibility(View.VISIBLE);
                ifDead(1);
            }
        } else if (v.getId() == R.id.p1p1){
            p1lives+=1;
            p1score.setText("" + p1lives);
        }else if (v.getId() == R.id.p1p5){
            p1lives+=5;
            p1score.setText("" + p1lives);
        } else if (v.getId() == R.id.p2m5){
            p2lives-=5;
            p2score.setText("" + p2lives);
            if(p2lives <= 0){
                TextView p2lost = (TextView)findViewById((R.id.l2));
                p2lost.setVisibility(View.VISIBLE);
                ifDead(2);
            }
        } else if (v.getId() == R.id.p2m1){
            p2lives-=1;
            p2score.setText("" + p2lives);
            if(p2lives <= 0){
                TextView p2lost = (TextView)findViewById((R.id.l2));
                p2lost.setVisibility(View.VISIBLE);
                ifDead(2);
            }
        } else if (v.getId() == R.id.p2p1){
            p2lives+=1;
            p2score.setText("" + p2lives);
        }else if (v.getId() == R.id.p2p5){
            p2lives+=5;
            p2score.setText("" + p2lives);
        } else if (v.getId() == R.id.p3m5){
            p3lives-=5;
            p3score.setText("" + p3lives);
            if(p3lives <= 0){
                TextView p3lost = (TextView)findViewById((R.id.l3));
                p3lost.setVisibility(View.VISIBLE);
                ifDead(3);
            }
        }else if (v.getId() == R.id.p3m1){
            p3lives-=1;
            p3score.setText("" + p3lives);
            if(p3lives <= 0){
                TextView p3lost = (TextView)findViewById((R.id.l3));
                p3lost.setVisibility(View.VISIBLE);
                ifDead(3);
            }
        } else if (v.getId() == R.id.p3p1){
            p3lives+=1;
            p3score.setText("" + p3lives);
        }else if (v.getId() == R.id.p3p5){
            p3lives+=5;
            p3score.setText("" + p3lives);
        }else if (v.getId() == R.id.p4m1){
            p4lives-=1;
            p4score.setText("" + p4lives);
            if(p4lives <= 0){
                TextView p4lost = (TextView)findViewById((R.id.l4));
                p4lost.setVisibility(View.VISIBLE);
                ifDead(4);
            }
        } else if (v.getId() == R.id.p4p1){
            p4lives+=1;
            p4score.setText("" + p4lives);
        }else if (v.getId() == R.id.p4p5){
            p4lives+=5;
            p4score.setText("" + p4lives);
        } else if (v.getId() == R.id.p4m5){
            p4lives-=5;
            p4score.setText("" + p4lives);
            if(p4lives <= 0){
                TextView p4lost = (TextView)findViewById((R.id.l4));
                p4lost.setVisibility(View.VISIBLE);
                ifDead(4);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("pLost", pLost);
        savedInstanceState.putInt("p1", p1lives);
        savedInstanceState.putInt("p2", p2lives);
        savedInstanceState.putInt("p3", p3lives);
        savedInstanceState.putInt("p4", p4lives);
    }

    public void ifDead(int player) {
        pLost = player;
        TextView lost = (TextView)findViewById((R.id.lost));
        lost.setVisibility(View.VISIBLE);
        lost.setText("PLAYER " + player + " LOST");
    }
}

