package mobi.appcent.onlinehaber.ui.search

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_search.*
import mobi.appcent.onlinehaber.R
import mobi.appcent.onlinehaber.adapter.HomePageAdapter
import mobi.appcent.onlinehaber.ui.home.HomeViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SearchFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private val newsAdapter = HomePageAdapter(arrayListOf())

    private lateinit var fragmentmanager:FragmentManager
    private lateinit var fragmenttransiction:FragmentTransaction

    var popularityAndSimilarity= ArrayList<String>()
     var  releaseDateArray= ArrayList<String>()
    private lateinit var dataAdapter:ArrayAdapter<String>
    private lateinit var dataAdapterTwo:ArrayAdapter<String>

    var contentText ="apple"
    var hoodText =""
    var dateTextOne =""
    var dateTextTwo =""
    var languageChek =""
    var countryCheck =""
    var popularity=""

    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val mounth = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        languageChecked()
       // countryChecked()
        dateButtonClick()
       relaseDateSpinnerClick()
       popularityAndSimilaritySpinnerClick()
        DetailSearchButtonClick()


    }


    fun languageChecked() {


        languegeTurkeySelect.setOnClickListener {


            if (languegeTurkeySelect.isChecked) {
                languageChek = "tr"
                languegeEnglandSelect.visibility = View.GONE
                languegeFranceSelect.visibility = View.GONE
                languegeGermanySelect.visibility = View.GONE
                languegeABDSelect.visibility = View.GONE
                languegeSpainSelect.visibility = View.GONE




            } else {
                languegeEnglandSelect.visibility = View.VISIBLE
                languegeFranceSelect.visibility = View.VISIBLE
                languegeGermanySelect.visibility = View.VISIBLE
                languegeABDSelect.visibility = View.VISIBLE
                languegeSpainSelect.visibility = View.VISIBLE

            }
        }

        languegeFranceSelect.setOnClickListener {

            if (languegeFranceSelect.isChecked) {
                languageChek = "fr"
                languegeTurkeySelect.visibility = View.GONE
                languegeGermanySelect.visibility = View.GONE
                languegeEnglandSelect.visibility = View.GONE
                languegeABDSelect.visibility = View.GONE
                languegeSpainSelect.visibility = View.GONE


            } else {
                languegeTurkeySelect.visibility = View.VISIBLE
                languegeEnglandSelect.visibility = View.VISIBLE
                languegeGermanySelect.visibility = View.VISIBLE
                languegeABDSelect.visibility = View.VISIBLE
                languegeSpainSelect.visibility = View.VISIBLE

            }


        }
        languegeEnglandSelect.setOnClickListener {

            if (languegeEnglandSelect.isChecked) {
                languageChek = "uk"
                languegeTurkeySelect.visibility = View.GONE
                languegeGermanySelect.visibility = View.GONE
                languegeABDSelect.visibility = View.GONE
                languegeSpainSelect.visibility = View.GONE
                languegeFranceSelect.visibility = View.GONE


            } else {
                languegeTurkeySelect.visibility = View.VISIBLE
                languegeFranceSelect.visibility = View.VISIBLE
                languegeGermanySelect.visibility = View.VISIBLE
                languegeABDSelect.visibility = View.VISIBLE
                languegeSpainSelect.visibility = View.VISIBLE

            }


        }
        languegeGermanySelect.setOnClickListener {

            if (languegeGermanySelect.isChecked) {
                languageChek = "de"
                languegeTurkeySelect.visibility = View.GONE
                languegeEnglandSelect.visibility = View.GONE
                languegeABDSelect.visibility = View.GONE
                languegeSpainSelect.visibility = View.GONE
                languegeFranceSelect.visibility = View.GONE


            } else {
                languegeTurkeySelect.visibility = View.VISIBLE
                languegeFranceSelect.visibility = View.VISIBLE
                languegeEnglandSelect.visibility = View.VISIBLE
                languegeABDSelect.visibility = View.VISIBLE
                languegeSpainSelect.visibility = View.VISIBLE

            }


        }
        languegeABDSelect.setOnClickListener {

            if (languegeABDSelect.isChecked) {
                languageChek = "us"
                languegeTurkeySelect.visibility = View.GONE
                languegeEnglandSelect.visibility = View.GONE
                languegeGermanySelect.visibility = View.GONE
                languegeSpainSelect.visibility = View.GONE
                languegeFranceSelect.visibility = View.GONE


            } else {
                languegeTurkeySelect.visibility = View.VISIBLE
                languegeFranceSelect.visibility = View.VISIBLE
                languegeEnglandSelect.visibility = View.VISIBLE
                languegeGermanySelect.visibility = View.VISIBLE
                languegeSpainSelect.visibility = View.VISIBLE

            }


        }
        languegeSpainSelect.setOnClickListener {

            if (languegeSpainSelect.isChecked) {
                languageChek = "es"
                languegeTurkeySelect.visibility = View.GONE
                languegeEnglandSelect.visibility = View.GONE
                languegeGermanySelect.visibility = View.GONE
                languegeABDSelect.visibility = View.GONE
                languegeFranceSelect.visibility = View.GONE


            } else {
                languegeTurkeySelect.visibility = View.VISIBLE
                languegeFranceSelect.visibility = View.VISIBLE
                languegeEnglandSelect.visibility = View.VISIBLE
                languegeGermanySelect.visibility = View.VISIBLE
                languegeABDSelect.visibility = View.VISIBLE

            }

        }
    }


    public fun countryChecked() {
        countryTurkeySelect.setOnClickListener {

            if (countryTurkeySelect.isChecked) {
                countryCheck = "tr"
                countryEnglandSelect.visibility = View.GONE
                countryFrenceSelect.visibility = View.GONE
                countryABDSelect.visibility = View.GONE
                countrySpainSelect.visibility = View.GONE
                countryGermanySelect.visibility = View.GONE


            } else {
                countryEnglandSelect.visibility = View.VISIBLE
                countryFrenceSelect.visibility = View.VISIBLE
                countryABDSelect.visibility = View.VISIBLE
                countrySpainSelect.visibility = View.VISIBLE
                countryGermanySelect.visibility = View.VISIBLE
                countryCheck = "tr"
            }
        }

        countryEnglandSelect.setOnClickListener {

            if (countryEnglandSelect.isChecked) {
                countryCheck = "uk"
                countryTurkeySelect.visibility = View.GONE
                countryFrenceSelect.visibility = View.GONE
                countryABDSelect.visibility = View.GONE
                countrySpainSelect.visibility = View.GONE
                countryGermanySelect.visibility = View.GONE


            } else {
                countryTurkeySelect.visibility = View.VISIBLE
                countryFrenceSelect.visibility = View.VISIBLE
                countryABDSelect.visibility = View.VISIBLE
                countrySpainSelect.visibility = View.VISIBLE
                countryGermanySelect.visibility = View.VISIBLE

            }


        }
        countryFrenceSelect.setOnClickListener {

            if (countryFrenceSelect.isChecked) {
                countryCheck = "fr"
                countryTurkeySelect.visibility = View.GONE
                countryEnglandSelect.visibility = View.GONE
                countryABDSelect.visibility = View.GONE
                countrySpainSelect.visibility = View.GONE
                countryGermanySelect.visibility = View.GONE


            } else {
                countryTurkeySelect.visibility = View.VISIBLE
                countryEnglandSelect.visibility = View.VISIBLE
                countryABDSelect.visibility = View.VISIBLE
                countrySpainSelect.visibility = View.VISIBLE
                countryGermanySelect.visibility = View.VISIBLE

            }


        }
        countryABDSelect.setOnClickListener {

            if (countryABDSelect.isChecked) {
                countryCheck = "us"
                countryTurkeySelect.visibility = View.GONE
                countryEnglandSelect.visibility = View.GONE
                countryFrenceSelect.visibility = View.GONE
                countrySpainSelect.visibility = View.GONE
                countryGermanySelect.visibility = View.GONE


            } else {
                countryTurkeySelect.visibility = View.VISIBLE
                countryEnglandSelect.visibility = View.VISIBLE
                countryFrenceSelect.visibility = View.VISIBLE
                countrySpainSelect.visibility = View.VISIBLE
                countryGermanySelect.visibility = View.VISIBLE

            }


        }
        countrySpainSelect.setOnClickListener {

            if (countrySpainSelect.isChecked) {
                countryCheck = "es"
                countryTurkeySelect.visibility = View.GONE
                countryEnglandSelect.visibility = View.GONE
                countryFrenceSelect.visibility = View.GONE
                countryABDSelect.visibility = View.GONE
                countryGermanySelect.visibility = View.GONE


            } else {
                countryTurkeySelect.visibility = View.VISIBLE
                countryEnglandSelect.visibility = View.VISIBLE
                countryFrenceSelect.visibility = View.VISIBLE
                countryABDSelect.visibility = View.VISIBLE
                countryGermanySelect.visibility = View.VISIBLE

            }


        }

        countryGermanySelect.setOnClickListener {

            if (countryGermanySelect.isChecked) {
                countryCheck = "de"
                countryTurkeySelect.visibility = View.GONE
                countryEnglandSelect.visibility = View.GONE
                countryFrenceSelect.visibility = View.GONE
                countryABDSelect.visibility = View.GONE
                countrySpainSelect.visibility = View.GONE


            } else {
                countryTurkeySelect.visibility = View.VISIBLE
                countryEnglandSelect.visibility = View.VISIBLE
                countryFrenceSelect.visibility = View.VISIBLE
                countryABDSelect.visibility = View.VISIBLE
                countrySpainSelect.visibility = View.VISIBLE

            }


        }
    }

    public fun dateButtonClick() {
        dateOne.setOnClickListener {

            val dpd = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                var monthh=month+1
                    dateTextOne = ("$year/$monthh/$dayOfMonth")
                    dateOne.setText(dateTextOne)
                },
                year,
                mounth,
                day
            )
            dpd.show()

        }
        dateTwo.setOnClickListener {
            val dpd = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    var monthh=month+1
                    dateTextTwo = ("$year-$monthh-$dayOfMonth")
                    dateTwo.setText(dateTextTwo)
                },
                year,
                mounth,
                day
            )
            dpd.show()

        }
    }

     fun DetailSearchButtonClick() {
        resultButton.setOnClickListener {
           contentText = contentSearchEdittext.text.toString()
         hoodText = hoodSearchEdittext.text.toString()
            viewModel.runThree("$contentText", "$countryCheck", "$hoodText", "$languageChek", "$dateTextOne", "$dateTextTwo", "$popularity")
            observeLiveData()

        findNavController().popBackStack()

        }

    }


    fun relaseDateSpinnerClick()
    {
        val simdikiZaman = Date()

        val df: DateFormat = SimpleDateFormat("yyyy/MM/dd")
        Log.d("yyyyyyy", "${df.format(simdikiZaman)}")

        releaseDateArray.add("Yayın Tarihi")
        releaseDateArray.add("Yeni Haberler")
        releaseDateArray.add("Eski Haberler")
        releaseDateArray.add("Manşetler")

        dataAdapter= ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,android.R.id.text1,releaseDateArray)
        releaseDate.adapter=dataAdapter
        releaseDate.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position==1)
                {
                    dateTextOne="${df.format(simdikiZaman)}"
                    Log.d("yyyyyyy", "${df.format(simdikiZaman)}")
                }
                if (position==2)
                {
                    popularity="publishedAt"
                    Log.d("yyyyyyy", "$popularity")
                }
                if (position==3)
                {
                    popularity="relevancy"
                    Log.d("yyyyyyy", "$popularity")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


    }
    fun popularityAndSimilaritySpinnerClick()
    {
        popularityAndSimilarity.add("Popülerite-Benzerlik")
       popularityAndSimilarity.add("En Çok Okunan")
        popularityAndSimilarity.add("Son Dakika")
       popularityAndSimilarity.add("Manşetler")

        dataAdapterTwo= ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,android.R.id.text1,popularityAndSimilarity)
        popularityAndSimilarityy.adapter=dataAdapterTwo
       popularityAndSimilarityy.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position==1)
                {
                    popularity="popularity"
                    Log.d("yyyyyyy", "$popularity")
                }
                if (position==2)
                {
                    popularity="publishedAt"
                    Log.d("yyyyyyy", "$popularity")
                }
                if (position==3)
                {
                    popularity="relevancy"
                    Log.d("yyyyyyy", "$popularity")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
    fun observeLiveData() {
        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            news?.let {


                newsAdapter.updateCountryList(news)

            }

        })

    }

}

