package com.tatayab.tatayab.main;

import android.content.Context;
import android.content.res.TypedArray;
 import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
 import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;

import com.tatayab.presentation.OperationType;
import com.tatayab.tatayab.R;
import com.tatayab.tatayab.customview.OnValueClickedListener;
import com.tatayab.tatayab.ext.ViewExt;

import kotlin.Unit;

public class ValueCounterView extends ConstraintLayout {

    View rootView;
    TextView valueTextView;
    ImageView subButton;
    ImageView addButton;
    private int minValue = 0;
    private int maxValue = 0;
    private int defaultValue = 0;
    private int valueColor = 0;
    int stepValue = 0;
    int valueTextSize = 12;
    private OnValueClickedListener mOnValueClickedListener = null;

    public ValueCounterView(Context context) {
        super(context);
        init(context);
    }

    public ValueCounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        getDefaultValues(context, attrs);
    }

    public ValueCounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        getDefaultValues(context, attrs);
    }

    public void setOnValueClickListener(OnValueClickedListener onValueClickListener) {
        this.mOnValueClickedListener = onValueClickListener;
    }

    private void getDefaultValues(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.ValueCounterView);

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        float displayDensity = dm.density;

        float defaultStrokeWidth = displayDensity * 2f;
        float defaultCornerRadius = displayDensity * 2f;


        if (typedArray.hasValue(R.styleable.ValueCounterView_minValue)) {
            minValue = typedArray.getInt(R.styleable.ValueCounterView_minValue, 1);
        }
        if (typedArray.hasValue(R.styleable.ValueCounterView_maxValue)) {
            maxValue = typedArray.getInt(R.styleable.ValueCounterView_maxValue, 1);
        }

        if (typedArray.hasValue(R.styleable.ValueCounterView_defaultValue)) {
            defaultValue = typedArray.getInt(R.styleable.ValueCounterView_defaultValue, 1);
            if (defaultValue < minValue || defaultValue > maxValue) {
                throw new RuntimeException("defaultValue must be in range ( minValue <= defaultValue <= maxValue)");
            }
        }


        if (typedArray.hasValue(R.styleable.ValueCounterView_valueColor)) {
            valueColor = typedArray.getInt(R.styleable.ValueCounterView_valueColor, 1);
        }


        if (typedArray.hasValue(R.styleable.ValueCounterView_valueTextSize)) {
            valueTextSize = typedArray.getDimensionPixelSize(R.styleable.ValueCounterView_valueTextSize, 12);
        }


        if (typedArray.hasValue(R.styleable.ValueCounterView_addButtonColor)) {
            int color = typedArray.getInt(R.styleable.ValueCounterView_addButtonColor, 1);
            DrawableCompat.setTint(addButton.getDrawable(), color);
        }

        if (typedArray.hasValue(R.styleable.ValueCounterView_subButtonColor)) {
            int color = typedArray.getInt(R.styleable.ValueCounterView_subButtonColor, 1);
            DrawableCompat.setTint(subButton.getDrawable(), color);

        }

        if (typedArray.hasValue(R.styleable.ValueCounterView_stepValue)) {
            stepValue = typedArray.getInt(R.styleable.ValueCounterView_stepValue, 1);
        }

        setValue(defaultValue);
        setValueColor(valueColor);
        setValueTextSize(valueTextSize);
        typedArray.recycle();
    }


    private void setValueTextSize(int valueTextSize) {
        if (valueTextSize > 0) {
            valueTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, valueTextSize);
        }
    }


    private void setValueColor(int valueColor) {
        valueTextView.setTextColor(valueColor);
    }


    private void init(Context context) {
        rootView = inflate(context, R.layout.view_counter, this);
        valueTextView = (TextView) rootView.findViewById(R.id.valueTextView);

        subButton = rootView.findViewById(R.id.subButton);
        addButton = rootView.findViewById(R.id.addButton);

        ViewExt.setSafeOnClickListener(subButton,view -> {
            mOnValueClickedListener.valueClicked(OperationType.SUBTRACT, decrementValue());
        return Unit.INSTANCE;
        });

        ViewExt.setSafeOnClickListener(addButton,view -> {
            mOnValueClickedListener.valueClicked(OperationType.ADD, incrementValue());
            return Unit.INSTANCE;
        });

    }

    private Integer incrementValue() {
        int currentVal = getValue();
        return currentVal + stepValue;

    }

    private Integer decrementValue() {
        int currentVal = getValue();
        return currentVal - 1;

    }

    public int getValueColor() {
        return valueColor;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getValue() {
        return defaultValue;
    }

    public void setValue(int newValue) {
        int value = newValue;
        if (newValue < minValue) {
            value = defaultValue;
        } else if (newValue > maxValue) {
            value = defaultValue;
        }

        valueTextView.setText(String.valueOf(value));
        this.defaultValue = value;
    }
}