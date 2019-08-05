package com.ruzhan.lion.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import android.util.AttributeSet;
import android.util.Property;

import com.ruzhan.common.R;
import com.ruzhan.lion.util.AnimUtils;
import com.ruzhan.lion.util.ColorUtils;

public class ParallaxScrImageView extends ForegroundImageView {

    private static final int[] STATE_PINNED = { R.attr.state_pinned };
    private Paint scrimPaint;
    private int imageOffset;
    private int minOffset;
    private Rect clipBounds = new Rect();
    private float scrimAlpha = 0f;
    private float maxScrimAlpha = 1f;
    private int scrimColor = Color.TRANSPARENT;
    private float parallaxFactor = -0.5f;
    private boolean isPinned = false;
    private boolean immediatePin = false;

    public ParallaxScrImageView(Context context) {
        super(context);
    }

    public ParallaxScrImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ParallaxScrImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ParallaxScrimageView);
        if (a.hasValue(R.styleable.ParallaxScrimageView_scrimColor)) {
            scrimColor = a.getColor(R.styleable.ParallaxScrimageView_scrimColor, scrimColor);
        }
        if (a.hasValue(R.styleable.ParallaxScrimageView_scrimAlpha)) {
            scrimAlpha = a.getFloat(R.styleable.ParallaxScrimageView_scrimAlpha, scrimAlpha);
        }
        if (a.hasValue(R.styleable.ParallaxScrimageView_maxScrimAlpha)) {
            maxScrimAlpha = a.getFloat(R.styleable.ParallaxScrimageView_maxScrimAlpha,
                    maxScrimAlpha);
        }
        if (a.hasValue(R.styleable.ParallaxScrimageView_parallaxFactor)) {
            parallaxFactor = a.getFloat(R.styleable.ParallaxScrimageView_parallaxFactor,
                    parallaxFactor);
        }
        a.recycle();

        scrimPaint = new Paint();
        scrimPaint.setColor(ColorUtils.modifyAlpha(scrimColor, scrimAlpha));
    }

    public static final Property<ParallaxScrImageView, Integer> OFFSET =
            AnimUtils.createIntProperty(new AnimUtils.IntProp<ParallaxScrImageView>("offset") {
                @Override
                public void set(ParallaxScrImageView parallaxScrimageView, int offset) {
                    parallaxScrimageView.setOffset(offset);
                }

                @Override
                public int get(ParallaxScrImageView parallaxScrimageView) {
                    return parallaxScrimageView.getOffset();
                }
            });

    public int getOffset() {
        return (int) getTranslationY();
    }

    public void setOffset(int offset) {
        offset = Math.max(minOffset, offset);
        if (offset != getTranslationY()) {
            setTranslationY(offset);
            imageOffset = (int) (offset * parallaxFactor);
            clipBounds.set(0, -offset, getWidth(), getHeight());
            setClipBounds(clipBounds);
            setScrimAlpha(Math.min(
                    ((float) -offset / getMinimumHeight()) * maxScrimAlpha, maxScrimAlpha));
            postInvalidateOnAnimation();
        }
        setPinned(offset == minOffset);
    }

    public void setScrimAlpha(@FloatRange(from = 0f, to = 1f) float alpha) {
        if (scrimAlpha != alpha) {
            scrimAlpha = alpha;
            scrimPaint.setColor(ColorUtils.modifyAlpha(scrimColor, scrimAlpha));
            postInvalidateOnAnimation();
        }
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean isPinned) {
        if (this.isPinned != isPinned) {
            this.isPinned = isPinned;
            refreshDrawableState();
            if (isPinned && immediatePin) {
                jumpDrawablesToCurrentState();
            }
        }
    }

    public void setScrimColor(@ColorInt int scrimColor) {
        if (this.scrimColor != scrimColor) {
            this.scrimColor = scrimColor;
            postInvalidateOnAnimation();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (h > getMinimumHeight()) {
            minOffset = getMinimumHeight() - h;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (imageOffset != 0) {
            final int saveCount = canvas.save();
            canvas.translate(0f, imageOffset);
            super.onDraw(canvas);
            canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), scrimPaint);
            canvas.restoreToCount(saveCount);
        } else {
            super.onDraw(canvas);
            canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), scrimPaint);
        }
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isPinned) {
            mergeDrawableStates(drawableState, STATE_PINNED);
        }
        return drawableState;
    }

    public boolean isImmediatePin() {
        return immediatePin;
    }

    /**
     * As the pinned state is designed to work with a {@see StateListAnimator}, we may want to short
     * circuit this animation in certain situations e.g. when flinging a list.
     */
    public void setImmediatePin(boolean immediatePin) {
        this.immediatePin = immediatePin;
    }
}
