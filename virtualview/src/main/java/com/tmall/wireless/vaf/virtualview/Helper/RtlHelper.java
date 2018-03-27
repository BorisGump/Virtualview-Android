package com.tmall.wireless.vaf.virtualview.Helper;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;

import java.util.Locale;

/**
 * Created on 2018/3/27.
 * Description:
 *
 * @author bianyue
 */
public class RtlHelper {

    /**
     * In Rtl env or not.
     * @return true if in Rtl env.
     */
    public static boolean isRtl() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return View.LAYOUT_DIRECTION_RTL == TextUtils.getLayoutDirectionFromLocale(Locale.getDefault());
        }

        return false;
    }

    /**
     * Convert left to RTL left if need.
     * @param parentLeft parent's left
     * @param parentWidth parent's width
     * @param left self's left
     * @param width self's width
     * @return
     */
    public static int getRealLeft(boolean isRtl, int parentLeft, int parentWidth, int left, int width) {
        if (isRtl) {
            // 1, trim the parent's left.
            left -= parentLeft;
            // 2, calculate the RTL left.
            left = parentWidth - width - left;
            // 3, add the parent's left.
            left += parentLeft;
        }
        return left;
    }
}