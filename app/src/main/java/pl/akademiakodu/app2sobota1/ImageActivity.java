package pl.akademiakodu.app2sobota1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageActivity extends AppCompatActivity {
    @BindView(R.id.imageViewHappy)
    public ImageView imageView;
    int ileHappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ileHappy = extras.getInt("howMuch");
        }

        if (ileHappy >= 50) {
            Picasso.with(this).load("http://images.clipartpanda.com/smile-clipart-smile-clip-art-66-350x350.jpg").into(imageView);
        } else {
            Picasso.with(this).load("http://images.clipartpanda.com/clipart-smiley-face-McLkKabca.jpeg").into(imageView);
        }
    }
}
