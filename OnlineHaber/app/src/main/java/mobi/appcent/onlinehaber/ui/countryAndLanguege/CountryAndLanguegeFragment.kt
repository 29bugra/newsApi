package mobi.appcent.onlinehaber.ui.countryAndLanguege

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_country_and_languege_list_dialog.*
import mobi.appcent.onlinehaber.R
import mobi.appcent.onlinehaber.adapter.HomePageAdapter
import mobi.appcent.onlinehaber.ui.home.HomeViewModel


class CountryAndLanguegeFragment : BottomSheetDialogFragment() {


    private lateinit var viewModel: HomeViewModel

    private val newsAdapter = HomePageAdapter(arrayListOf())


    var deger: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_country_and_languege_list_dialog,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        radioChecked()
        butonClick()

    }

    public fun radioChecked() {
        RadioTurkey.setOnCheckedChangeListener { group, checked ->
            deger = "tr"
        }
        RadioGermany.setOnCheckedChangeListener { group, checked ->
            deger = "de"
        }
        RadioABD.setOnCheckedChangeListener { group, checked ->
            deger = "us"
        }
        RadioSpain.setOnCheckedChangeListener { group, checked ->
            deger = "be"
        }
        RadioEngland.setOnCheckedChangeListener { group, checked ->
            deger = "ae"
        }
        RadioFrance.setOnCheckedChangeListener { group, checked ->
            deger = "fr"

        }

    }

     fun butonClick() {
        select.setOnClickListener {

            viewModel.runTwo("$deger")
            observeLiveData()
            dismiss()


        }

    }


    fun observeLiveData() {
        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            news?.let {
                newsAdapter.notifyDataSetChanged()

                newsAdapter.updateCountryList(news)

            }

        })

    }

}