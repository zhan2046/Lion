package com.ruzhan.lion.util;

import android.content.Context;
import android.os.Build;
import android.util.IntProperty;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/**
 * Created by ruzhan123 on 2018/7/5.
 */
public class AnimUtils {

    private static Interpolator fastOutSlowIn;

    private AnimUtils() {}

    public static Interpolator getFastOutSlowInInterpolator(Context context) {
        if (fastOutSlowIn == null) {
            fastOutSlowIn = AnimationUtils.loadInterpolator(context,
                    android.R.interpolator.fast_out_slow_in);
        }
        return fastOutSlowIn;
    }

    /**
     * A delegate for creating a {@link Property} of <code>int</code> type.
     */
    public static abstract class IntProp<T> {

        public final String name;

        public IntProp(String name) {
            this.name = name;
        }

        public abstract void set(T object, int value);
        public abstract int get(T object);
    }

    /**
     * The animation framework has an optimization for <code>Properties</code> of type
     * <code>int</code> but it was only made public in API24, so wrap the impl in our own type
     * and conditionally create the appropriate type, delegating the implementation.
     */
    public static <T> Property<T, Integer> createIntProperty(final IntProp<T> impl) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return new IntProperty<T>(impl.name) {
                @Override
                public Integer get(T object) {
                    return impl.get(object);
                }

                @Override
                public void setValue(T object, int value) {
                    impl.set(object, value);
                }
            };
        } else {
            return new Property<T, Integer>(Integer.class, impl.name) {
                @Override
                public Integer get(T object) {
                    return impl.get(object);
                }

                @Override
                public void set(T object, Integer value) {
                    impl.set(object, value);
                }
            };
        }
    }
}
