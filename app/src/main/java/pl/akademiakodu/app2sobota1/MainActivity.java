package pl.akademiakodu.app2sobota1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextLogin)
    EditText editTextLogin;
    @BindView(R.id.editTextPass)
    EditText editTextPass;
    @BindView(R.id.textViewPass)
    TextView Pass;
    @BindView(R.id.textViewLogin)
    TextView Login;
    @BindView(R.id.textViewIle)
    TextView ile;
    @BindView(R.id.editTextIle)
    EditText EditIle;
    @BindView(R.id.happyOrNotButton)
    public Button happyOrNotButton;
    StringBuffer login = new StringBuffer();
    StringBuffer pass = new StringBuffer();
    String correctLog = "oskar";
    String correctPass = "password12";
    public Integer ileHappy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //   Toast.makeText(this, login.toString(), Toast.LENGTH_LONG).show();


        //Picasso.with(this).load("http://images.clipartpanda.com/smile-clipart-smile-clip-art-66-350x350.jpg").into(imageView);
    }
    /*@OnTextChanged(R.id.editTextLogin)
    public void changeText (CharSequence text){

    }*/

    @OnClick(R.id.buttonLog)
    public void log() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        login.delete(0, login.length());
        pass.delete(0, pass.length());

        login.append(editTextLogin.getText());
        pass.append(editTextPass.getText());


        if (login.toString().equals(correctLog)) {
            if (correctPass.equals(pass.toString())) {
                ile.setVisibility(View.VISIBLE);
                EditIle.setVisibility(View.VISIBLE);
                EditIle.setInputType(InputType.TYPE_CLASS_NUMBER);
                InputMethodManager keyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(EditIle, InputMethodManager.SHOW_IMPLICIT);
                happyOrNotButton.setVisibility(View.VISIBLE);
            } else {

                alertDialog.setMessage("Wrong password");

                alertDialog.show();
                Toast.makeText(this, "Access denied", Toast.LENGTH_LONG).show();

            }

            Toast.makeText(this, "Access granded", Toast.LENGTH_LONG).show();
            InputMethodManager keyboard = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            keyboard.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        } else {
            alertDialog.setMessage("Wrong login");

            alertDialog.show();
            Toast.makeText(this, "Access denied", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.happyOrNotButton)
    public void happiness() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("ERROR");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        try {
            ileHappy = Integer.parseInt(EditIle.getText().toString());
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtra("howMuch", ileHappy);
            startActivity(intent);
        } catch (NumberFormatException e) {
            alertDialog.setMessage("incorrect data");
            alertDialog.show();
        }



    }
}
