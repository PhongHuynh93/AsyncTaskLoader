package dhbk.android.asynctaskloader;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by huynhducthanhphong on 4/14/16.
 * Make adapter for listview
 */
public class EmployeeAdapter extends BaseAdapter {
    private static final String TAG = EmployeeAdapter.class.getName();
    private final ArrayList<Employee> employees;
    private LayoutInflater inflater;
    private ArrayList<Employee> mEmployees;

    public EmployeeAdapter(Context context, ArrayList<Employee> employees) {
        this.employees = employees;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, Constant.LOADER_ACTIVITY + "getView: ");
        ViewHolder viewHolder;
        Employee emp = (Employee) getItem(position);
        // tạo viewholder tiết kiệm bộ nhớ
        if (convertView == null) {
            Log.i(TAG, Constant.LOADER_ACTIVITY + "getView: convertView = null");
            convertView = inflater.inflate(R.layout.employeedata, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mEmpid.setText(emp.empid);
        viewHolder.mEmpname.setText(emp.name);
        return convertView;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        Log.i(TAG, Constant.LOADER_ACTIVITY + "setEmployees: " + employees.get(0).name);
        this.employees.addAll(employees);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.empid)
        TextView mEmpid;
        @Bind(R.id.empname)
        TextView mEmpname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
