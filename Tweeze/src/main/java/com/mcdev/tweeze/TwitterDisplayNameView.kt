package com.mcdev.tweeze

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.mcdev.tweeze.databinding.TwitterDisplayNameViewBinding
import com.mcdev.tweeze.util.VerifiedBadge

/**
 * A convenient view sets the display name of a twitter user. This view
 * appends the twitter verified badge when necessary.
 */
class TwitterDisplayNameView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defaultStyle: Int = 0
) : FrameLayout(context, attributeSet, defaultStyle) {

    private val binding =
        TwitterDisplayNameViewBinding.inflate(LayoutInflater.from(context), this, true)

    /** Get the user's display name */
    var displayName: String? = null
        private set

    /**
     *  Customize the display name text */
    val customizeDisplayName: TextView
        get() = binding.tweezeDisplayName

    var textSize: Int = 0
        set(value) {
            // setting display name text view
            binding.tweezeDisplayName.textSize = value.toFloat()

            // get the size to set for verified badge
            val getTextSize = binding.tweezeDisplayName.textSize

            // setting display name verified badge width and height
            binding.tweezeDisplayNameVerifiedBadge.requestLayout()
            binding.tweezeDisplayNameVerifiedBadge.layoutParams.height = getTextSize.toInt()
            binding.tweezeDisplayNameVerifiedBadge.layoutParams.width = getTextSize.toInt()
            field = value
        }

    init {
        val a = context.obtainStyledAttributes(
            attributeSet, R.styleable.TwitterDisplayNameView, defaultStyle, 0
        )

        /*TypedArrays are heavyweight objects that should be recycled immediately
        after all the attributes you need have been extracted.*/
        a.recycle()
    }

    /**
     * set display name.
     *
     * @param displayName
     * @param isVerified
     */
    fun setDisplayName(displayName: String, isVerified: Boolean, verifiedBadgeType: VerifiedBadge = VerifiedBadge.DEFAULT) {
        when (isVerified) {
            true -> {
                // make verified badge visible when user is verified
                binding.tweezeDisplayNameVerifiedBadge.visibility = View.VISIBLE
            }
            false -> {    // make verified badge invisible when user is not verified
                binding.tweezeDisplayNameVerifiedBadge.visibility = View.GONE
            }
        }

        when (verifiedBadgeType) {
            VerifiedBadge.WHITE -> {
                // set white verified badge
                binding.tweezeDisplayNameVerifiedBadge.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_twitter_verified_badge_white,
                        context.theme
                    )
                )
            }
            VerifiedBadge.BLACK -> {
                // set black verified badge
                binding.tweezeDisplayNameVerifiedBadge.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_twitter_verified_badge_black,
                        context.theme
                    )
                )
            }
            else -> {
                // set default verified badge
                binding.tweezeDisplayNameVerifiedBadge.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_twitter_verified_badge,
                        context.theme
                    )
                )
            }
        }

        // set global variable
        this.displayName = displayName

        // set text
        customizeDisplayName.text = displayName

        binding.tweezeDisplayNameVerifiedBadge.requestLayout()
        binding.tweezeDisplayNameVerifiedBadge.layoutParams.height = customizeDisplayName.textSize.toInt()
        binding.tweezeDisplayNameVerifiedBadge.layoutParams.width = customizeDisplayName.textSize.toInt()
    }
}