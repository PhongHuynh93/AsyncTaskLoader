package dhbk.android.asynctaskloader;

import android.content.Context;
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
    private final ArrayList<Employee> employees;
    private LayoutInflater inflater;

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
        ViewHolder viewHolder;
        Employee emp = (Employee) getItem(position);
        // tạo viewholder tiết kiệm bộ nhớ
        if (convertView == null) {
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
