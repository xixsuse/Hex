package com.sam.hex.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.vending.billing.util.IabResult;
import com.android.vending.billing.util.Purchase;
import com.sam.hex.R;
import com.sam.hex.Stats;
import com.sam.hex.view.HexDialogView.Button.OnClickListener;

/**
 * @author Will Harmon
 **/
public class DonateDialog extends HexDialog {
    public DonateDialog(Context context) {
        super(context);
    }

    public DonateDialog() {
        super();
    }

    @Override
    public View getPositiveView() {
        View v = View.inflate(this, R.layout.dialog_view_donate, null);

        ImageView iv = (ImageView) v.findViewById(R.id.image);
        iv.setImageResource(R.drawable.donate_gold_d);

        TextView tv = (TextView) v.findViewById(R.id.text);
        tv.setText(R.string.donate_gold);

        TextView price = (TextView) v.findViewById(R.id.price);
        price.setText(R.string.donate_gold_price);

        return v;
    }

    @Override
    public View getNegativeView() {
        View v = View.inflate(this, R.layout.dialog_view_donate, null);

        ImageView iv = (ImageView) v.findViewById(R.id.image);
        iv.setImageResource(R.drawable.donate_bronze_d);

        TextView tv = (TextView) v.findViewById(R.id.text);
        tv.setText(R.string.donate_bronze);

        TextView price = (TextView) v.findViewById(R.id.price);
        price.setText(R.string.donate_bronze_price);

        return v;
    }

    @Override
    public View getNeutralView() {
        View v = View.inflate(this, R.layout.dialog_view_donate, null);

        ImageView iv = (ImageView) v.findViewById(R.id.image);
        iv.setImageResource(R.drawable.donate_silver_d);

        TextView tv = (TextView) v.findViewById(R.id.text);
        tv.setText(R.string.donate_silver);

        TextView price = (TextView) v.findViewById(R.id.price);
        price.setText(R.string.donate_silver_price);

        return v;
    }

    @NonNull
    @Override
    public OnClickListener getPositiveOnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick() {
                purchaseItem(ITEM_SKU_ADVANCED);
                dismiss();
            }
        };
    }

    @NonNull
    @Override
    public OnClickListener getNegativeOnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick() {
                purchaseItem(ITEM_SKU_BASIC);
                dismiss();
            }
        };
    }

    @NonNull
    @Override
    public OnClickListener getNeutralOnClickListener() {
        return new OnClickListener() {
            @Override
            public void onClick() {
                purchaseItem(ITEM_SKU_INTERMEDIATE);
                dismiss();
            }
        };
    }

    @Override
    protected void onPurchaseSuccess(IabResult result, @NonNull Purchase info) {
        String sku = info.getSku();

        int amount = 0;
        switch (sku) {
            case ITEM_SKU_BASIC:
                amount = 1;
                break;
            case ITEM_SKU_INTERMEDIATE:
                amount = 3;
                break;
            case ITEM_SKU_ADVANCED:
                amount = 5;
                break;
        }
        Stats.incrementDonationRank(this, amount);

        dismiss();
    }

    @Override
    public float getPositiveXPercent() {
        return 0.45f;
    }

    @Override
    public float getPositiveYPercent() {
        return 0.30f;
    }

    @Override
    public float getPositiveSideLengthPercent() {
        return 0.15f;
    }

    @Override
    public float getNegativeXPercent() {
        return 0.20f;
    }

    @Override
    public float getNegativeYPercent() {
        return 0.70f;
    }

    @Override
    public float getNegativeSideLengthPercent() {
        return 0.13f;
    }

    @Override
    public float getNeutralXPercent() {
        return 0.77f;
    }

    @Override
    public float getNeutralYPercent() {
        return 0.65f;
    }

    @Override
    public float getNeutralSideLengthPercent() {
        return 0.14f;
    }
}
