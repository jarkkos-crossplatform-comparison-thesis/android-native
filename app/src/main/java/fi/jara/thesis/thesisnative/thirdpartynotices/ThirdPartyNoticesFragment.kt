package fi.jara.thesis.thesisnative.thirdpartynotices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fi.jara.thesis.thesisnative.R

class ThirdPartyNoticesFragment(): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.third_party_notices, container, false)
    }
}