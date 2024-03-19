package com.example.myapplication;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.contract.SignupContract;
import com.example.myapplication.model.SignupModel;
import com.example.myapplication.presenter.SignupPresenter;

public class MainActivity extends AppCompatActivity implements SignupContract.View {
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private SignupContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signUpButton);

        // Initialize presenter
        presenter = new SignupPresenter(this, new SignupContract.Model() {
            @Override
            public void performSignup(SignupModel signupModel) {
                // Simulate sign-up success for demonstration purposes
                presenter.onSignupSuccess("Signup successful!");
            }
        });

        // Sign Up Button Click Listener
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                presenter.signup(username, email, password);
            }
        });

    }

    @Override
    public void showSignupSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSignupErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
