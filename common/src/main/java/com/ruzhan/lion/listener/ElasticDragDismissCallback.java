package com.ruzhan.lion.listener;

/**
 * Created by ruzhan123 on 2018/7/5.
 */
public interface ElasticDragDismissCallback {

    /**
     * Called for each drag event.
     *
     * @param elasticOffset       Indicating the drag offset with elasticity applied i.e. may
     *                            exceed 1.
     * @param elasticOffsetPixels The elastically scaled drag distance in pixels.
     * @param rawOffset           Value from [0, 1] indicating the raw drag offset i.e.
     *                            without elasticity applied. A value of 1 indicates that the
     *                            dismiss distance has been reached.
     * @param rawOffsetPixels     The raw distance the user has dragged
     */
    void onDrag(float elasticOffset, float elasticOffsetPixels,
                float rawOffset, float rawOffsetPixels);

    /**
     * Called when dragging is released and has exceeded the threshold dismiss distance.
     */
    void onDragDismissed();
}
