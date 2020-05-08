package sg.edu.rp.c346.s19040010.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    EditText etAmt;
    EditText pax;
    TextView tvamount;
    ToggleButton svs;
    ToggleButton gst;
    TextView totalBill;
    TextView splitPays;
    Button split;
    Button reset;
    EditText discount;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvamount = findViewById(R.id.textAmount);
        etAmt = findViewById(R.id.inputAmount);
        pax = findViewById(R.id.editInputNumberOfPax);
        discount = findViewById(R.id.editInputDiscount);
        svs = findViewById(R.id.tbSvs);
        gst = findViewById(R.id.tbGst);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvamount.getText().toString().trim().length()!=0 && pax.getText().toString().trim().length()!=0) {
                    double amount = 0.0;
                    if (!svs.isChecked() && !gst.isChecked()) {
                        amount = Double.parseDouble(etAmt.getText().toString());
                    }
                        else if(svs.isChecked() && !gst.isChecked()) {
                            amount = Double.parseDouble(etAmt.getText().toString()) * 1.1;
                        }
                        else if(!svs.isChecked() && gst.isChecked()) {
                            amount = Double.parseDouble(etAmt.getText().toString()) * 1.07;
                        }
                        else {
                            amount = Double.parseDouble(etAmt.getText().toString()) * 1.17;
                            }
                        }

                    // Discount
                    if(discount.getText().toString().trim().length() != 0) {
                        discount  *=1 - Double.parseDouble(discount.getText().toString()) / 100;
                    }

                    totalBill.setText("Total Bill: $" + String.format("%.2f", tvamount));
                    int numPerson = Integer.parseInt(pax.getText().toString());
                    if (numPerson != 1) {
                        splitPays.setText("Each Pays: $" + String.format("%.2f", tvamount / numPerson));
                    }
                    else {
                        splitPays.setText("Each Pays: $" + t);
                    }
                }
            });
        }
    }
