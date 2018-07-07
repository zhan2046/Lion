package com.ruzhan.lion.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;

import com.ruzhan.common.R;

/**
 * Created by ruzhan123 on 2018/7/5.
 */
public class ViewUtils {

    public static Drawable getPlaceholder(Context context, int position) {
        int[] placeholderColors = context.getResources().getIntArray(R.array.loading_placeholders_grey);
        return new ColorDrawable(placeholderColors[position % placeholderColors.length]);
    }

    /**
     * Determine if the navigation bar will be on the bottom of the screen, based on logic in
     * PhoneWindowManager.
     */
    public static boolean isNavBarOnBottom(@NonNull Context context) {
        final Resources res = context.getResources();
        final Configuration cfg = context.getResources().getConfiguration();
        final DisplayMetrics dm = res.getDisplayMetrics();
        boolean canMove = (dm.widthPixels != dm.heightPixels &&
                cfg.smallestScreenWidthDp < 600);
        return (!canMove || dm.widthPixels < dm.heightPixels);
    }

    public static void setLightStatusBar(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
        }
    }

    public static RippleDrawable createRipple(@Nullable Palette palette,
                                              @FloatRange(from = 0f, to = 1f) float darkAlpha,
                                              @FloatRange(from = 0f, to = 1f) float lightAlpha,
                                              @ColorInt int fallbackColor,
                                              boolean bounded) {
        int rippleColor = fallbackColor;
        if (palette != null) {
            // try the named swatches in preference order
            if (palette.getVibrantSwatch() != null) {
                rippleColor =
                        ColorUtils.modifyAlpha(palette.getVibrantSwatch().getRgb(), darkAlpha);

            } else if (palette.getLightVibrantSwatch() != null) {
                rippleColor = ColorUtils.modifyAlpha(palette.getLightVibrantSwatch().getRgb(),
                        lightAlpha);
            } else if (palette.getDarkVibrantSwatch() != null) {
                rippleColor = ColorUtils.modifyAlpha(palette.getDarkVibrantSwatch().getRgb(),
                        darkAlpha);
            } else if (palette.getMutedSwatch() != null) {
                rippleColor = ColorUtils.modifyAlpha(palette.getMutedSwatch().getRgb(), darkAlpha);
            } else if (palette.getLightMutedSwatch() != null) {
                rippleColor = ColorUtils.modifyAlpha(palette.getLightMutedSwatch().getRgb(),
                        lightAlpha);
            } else if (palette.getDarkMutedSwatch() != null) {
                rippleColor =
                        ColorUtils.modifyAlpha(palette.getDarkMutedSwatch().getRgb(), darkAlpha);
            }
        }
        return new RippleDrawable(ColorStateList.valueOf(rippleColor), null,
                bounded ? new ColorDrawable(Color.WHITE) : null);
    }

    public static final Property<Drawable, Integer> DRAWABLE_ALPHA
            = AnimUtils.createIntProperty(new AnimUtils.IntProp<Drawable>("alpha") {
        @Override
        public void set(Drawable drawable, int alpha) {
            drawable.setAlpha(alpha);
        }

        @Override
        public int get(Drawable drawable) {
            return drawable.getAlpha();
        }
    });
}
