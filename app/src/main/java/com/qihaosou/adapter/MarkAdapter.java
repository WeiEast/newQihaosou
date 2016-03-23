package com.qihaosou.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qihaosou.R;
import com.qihaosou.bean.CompanyLogoBean;
import com.qihaosou.ui.base.ListBaseAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author: Created by wenjundu
 * Date:on 2016/3/23
 * Description:
 */
public class MarkAdapter extends ListBaseAdapter<CompanyLogoBean> {
    static class ViewHolder{
        @InjectView(R.id.mark_icon_iv)
        ImageView markIconIV;
        @InjectView(R.id.tv_mark_name)
        TextView markNameTV;
        @InjectView(R.id.tv_mark_category)
        TextView markCateTV;
        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    @Override
    protected View getRealView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = getLayoutInflater(parent.getContext()).inflate(
                    R.layout.item_mark_listview, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        CompanyLogoBean companyLogoBean=mDatas.get(position);
        vh.markNameTV.setText(companyLogoBean.getRegName());
        vh.markCateTV.setText(companyLogoBean.getSbName());
        return convertView;
    }
}
