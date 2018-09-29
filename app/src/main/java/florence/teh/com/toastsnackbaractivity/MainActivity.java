package florence.teh.com.toastsnackbaractivity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSnack = findViewById(R.id.btn_snackbar);
        Button buttonToast = findViewById(R.id.btn_toast);
        Button buttonSnack2 = findViewById(R.id.btn_snackbaraction);
        final ConstraintLayout constraintLayout = findViewById(R.id.main_layout_id);

        buttonToast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "INOM TAYO.", Toast.LENGTH_SHORT).show();
            }
        });

        buttonSnack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                View view = findViewById(R.id.main_layout_id);
                String message = "Successfully added!";
                int duration = Snackbar.LENGTH_LONG;

                showSnackbar(view, message, duration);
            }
        });

        buttonSnack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(constraintLayout, "Successfully removed!", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbaraction = Snackbar.make(constraintLayout, "Successfully restored!", Snackbar.LENGTH_SHORT);
                                snackbaraction.show();
                            }
                        });

                snackbar.show();
            }

        });
    }

    public void showSnackbar(View view, String message, int duration)
    {
        Snackbar.make(view, message, duration).show();
    }
}