package mx.delasalle.imcapp

//import junit.framework.TestCase.assertEquals
import mx.delasalle.imcapp.ui.viewmodels.BMIViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BMIViewModelTest {
    private lateinit var bmiViewModel: BMIViewModel
    @Before
    fun setup(){
        bmiViewModel = BMIViewModel()
    }

    @Test
    fun calculateBMICorrectlyForNormalWeight(){
        // Arrange
        bmiViewModel.weight.value = "70"
        //bmiViewModel.height.value = "1.75"
        bmiViewModel.height.value = "2.0"
        // Act
        bmiViewModel.calculateBMI()
        // Assert
        assertEquals("22.86",bmiViewModel.bmiResult.value)
        assertEquals(R.drawable.normal_weight,bmiViewModel.imageResource.value)
    }

}