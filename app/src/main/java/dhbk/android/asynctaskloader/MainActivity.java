package dhbk.android.asynctaskloader;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Employee>> {

    private static final String TAG = MainActivity.class.getName();
    @Bind(R.id.employee_list)
    ListView mEmployees;
    private EmployeeAdapter empAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // lúc này list empty
        empAdapter = new EmployeeAdapter(this, new ArrayList<Employee>());
        mEmployees.setAdapter(empAdapter);

        // load data vao list
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();

        // sau khi load thì xét xem list có item nào ko
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onCreate: " + mEmployees.getCount());
    }

    // Instantiate and return a new Loader for the given ID.
    @Override
    public Loader<ArrayList<Employee>> onCreateLoader(int id, Bundle args) {
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onCreateLoader");
        return new EmployeeLoader(MainActivity.this);
    }


    // Called when a previously created loader has finished its load.
    @Override
    public void onLoadFinished(Loader<ArrayList<Employee>> loader, ArrayList<Employee> data) {
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onLoadFinished: ");
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onLoadFinished: " + data.get(0).name);
        empAdapter.setEmployees(data);
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onLoadFinished: List count " + mEmployees.getCount());
    }

    // Called when a previously created loader is being reset, and thus making its data unavailable.
    @Override
    public void onLoaderReset(Loader<ArrayList<Employee>> loader) {
        // xóa data cũ
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onLoaderReset: ");
        empAdapter.setEmployees(new ArrayList<Employee>());
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, Constant.LOADER_ACTIVITY + "onStart: ");
    }
}
