package dhbk.android.asynctaskloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.employee_list)
    ListView mEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //
        EmployeeAdapter empAdapter = new EmployeeAdapter(this, new ArrayList<Employee>());
        mEmployees.setAdapter(empAdapter);

    }
}
