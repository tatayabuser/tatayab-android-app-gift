package com.tatayab.tatayab.util

import android.util.LayoutDirection
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper
import androidx.recyclerview.widget.OrientationHelper.createVerticalHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


class MultiSnapHelper(
    private val interval: Int = DEFAULT_INTERVAL,
    private var  index : Int = 0,
    private val speedMsPerInch: Float = DEFAULT_SPEED_MS_PER_INCH
) : SnapHelper() {

    private var coordinateHelper: CoordinateHelper?= null
    private var orientationHelper: OrientationHelper? = null
    private var recyclerView: RecyclerView? = null

    override fun attachToRecyclerView(recyclerView: RecyclerView?) {
        super.attachToRecyclerView(recyclerView)
        Log.d("Direction is ... >>>>", recyclerView?.layoutManager!!.layoutDirection.toString())
        this.recyclerView = recyclerView
    }

    /**
     * Calculates the distance from [targetView].
     * This will be calculated based off of the specified [SnapGravity].
     */
    override fun calculateDistanceToFinalSnap(
        layoutManager: RecyclerView.LayoutManager,
        targetView: View
    ): IntArray {
        val helper = getOrientationHelper(layoutManager)
        val distance = getCoordinateDelta(targetView, helper,layoutManager)
        return intArrayOf(
            if (layoutManager.canScrollHorizontally()) distance else 0, // x-axis
            if (layoutManager.canScrollVertically()) distance else 0 // y-axis
        )
    }

    /**
     * Finds and returns the views to snap.
     *
     * Iterates the all children views currently inflated and calculates the distance from base coordinate.
     * After checking all the children views, returns the child view that has the closest distance.
     * If all children views are invalid, just returns null.
     */
    override fun findSnapView(layoutManager: RecyclerView.LayoutManager): View? {
        return null
    }

    /**
     * Finds and returns the next index to snap.
     *
     * For forward scrolling, this tries to find the index from the first index by incrementing.
     * Returns the index if the valid next index is found, otherwise returns the final index which means reaching the end edge.
     *
     * For backward scrolling, this tries to find the index from the last index by decrementing.
     * Returns the index if the valid next index is found, otherwise returns the final index which means reaching the start edge.
     */
    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager,
        velocityX: Int,
        velocityY: Int
    ): Int {
        val velocity = if (layoutManager.canScrollHorizontally()) velocityX else velocityY
        if (layoutManager.layoutDirection== LayoutDirection.LTR) {
            val lastIndex = layoutManager.itemCount - 2
            if (velocity > 0 && index < lastIndex)
                index += 2
            else if (velocity < 0 && index > 0)
                index -= 2
        }
        else
        {
            val lastIndex = layoutManager.itemCount - 2
            if (velocity > 0 && index > 0)
                index -= 2
            else if (velocity < 0 && index <lastIndex)
                index += 2
        }
        return index // reached the edge
    }

    /**
     * Creates a scroller to make a smooth scroll with specified speed.
     *
     * This is almost the same as [SnapHelper.createSnapScroller] except for the speed handling.
     */


    /**
     * Gets the delta between base coordinate and [targetView] coordinate.
     * If the returned value is positive, it means [targetView] is after the base coordinate,
     * otherwise [targetView] is before the base coordinate.
     */
    private fun getCoordinateDelta(targetView: View, orientationHelper: OrientationHelper,layoutManager: RecyclerView.LayoutManager): Int {
         coordinateHelper = createLayoutPositionHelper(layoutManager)

        val childCoordinate = coordinateHelper?.getTargetCoordinate(targetView, orientationHelper)
        val baseCoordinate = coordinateHelper?.getBaseCoordinate(orientationHelper)
        return childCoordinate!! - baseCoordinate!!

    }

    /**
     * Gets [OrientationHelper] based on the layout orientation.
     * If [OrientationHelper] was created before, it returns the one previously created.
     */
    private fun getOrientationHelper(layoutManager: RecyclerView.LayoutManager): OrientationHelper {
        return orientationHelper ?: when {
            layoutManager.canScrollHorizontally() -> createHorizontalHelper(layoutManager)
            layoutManager.canScrollVertically() -> createVerticalHelper(layoutManager)
            else -> throw IllegalStateException("unknown orientation")
        }.also { newOrientationHelper ->
            this.orientationHelper = newOrientationHelper
        }
    }



    private fun createLayoutPositionHelper(layoutManger: RecyclerView.LayoutManager): CoordinateHelper {
        return when (layoutManger.layoutDirection) {
            LayoutDirection.RTL -> EndCoordinateHelper()
            LayoutDirection.LTR -> StartCoordinateHelper()
            else -> StartCoordinateHelper()
        }
    }



    companion object {

        val DEFAULT_GRAVITY =
            SnapGravity.END

        const val DEFAULT_INTERVAL = 2

        const val DEFAULT_SPEED_MS_PER_INCH = 100f
    }

    enum class SnapGravity(val value: Int) {

        /**
         * gravity to center.
         */
        CENTER(0),

        /**
         * gravity to start (left or top).
         */
        START(1),

        /**
         * gravity to start (right or bottom).
         */
        END(2);

        companion object {

            fun valueOf(value: Int): SnapGravity {
                for (gravity in values()) {
                    if (gravity.value == value) {
                        return gravity
                    }
                }
                throw IllegalArgumentException("no such enum object for the value: $value")
            }
        }
    }





}


class EndCoordinateHelper : CoordinateHelper {

    /**
     * Gets the coordinate of the end of RecyclerView.
     */
    override fun getBaseCoordinate(helper: OrientationHelper): Int {
        return helper.endAfterPadding
    }

    /**
     * Gets the coordinate from the end of [targetView].
     */
    override fun getTargetCoordinate(targetView: View, helper: OrientationHelper): Int {
        return helper.getDecoratedStart(targetView) + helper.getDecoratedMeasurement(targetView)
    }
}


interface CoordinateHelper {

    /**
     * find the coordinate of RceyclerView.
     */
    fun getBaseCoordinate(helper: OrientationHelper): Int

    /**
     * find the coordinate of [targetView] in RecyclerView.
     */
    fun getTargetCoordinate(targetView: View, helper: OrientationHelper): Int
}


class CenterCoordinateHelper : CoordinateHelper {

    /**
     * Gets the coordinate of the center of RecyclerView.
     */
    override fun getBaseCoordinate(helper: OrientationHelper): Int {
        return helper.startAfterPadding + helper.totalSpace / 2
    }

    /**
     * Gets the coordinate from the center of [targetView].
     */
    override fun getTargetCoordinate(targetView: View, helper: OrientationHelper): Int {
        return helper.getDecoratedStart(targetView) + helper.getDecoratedMeasurement(targetView) / 2
    }
}


class StartCoordinateHelper : CoordinateHelper {

    /**
     * Gets the coordinate of the start of RecyclerView.
     */
    override fun getBaseCoordinate(helper: OrientationHelper): Int {
        return helper.startAfterPadding
    }

    /**
     * Gets the coordinate from the start of [targetView].
     */
    override fun getTargetCoordinate(targetView: View, helper: OrientationHelper): Int {
        return helper.getDecoratedStart(targetView)
    }
}
