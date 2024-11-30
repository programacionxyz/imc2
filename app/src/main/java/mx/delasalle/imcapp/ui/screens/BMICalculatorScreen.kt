package mx.delasalle.imcapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mx.delasalle.imcapp.R
import mx.delasalle.imcapp.ui.viewmodels.BMIViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BMICalculatorScreen(bmiViewModel: BMIViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = bmiViewModel.weight.value,
            onValueChange = { bmiViewModel.weight.value = it },
            label = { Text(stringResource(id = R.string.weight)) },
            //label = { Text("Weight")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = bmiViewModel.height.value,
            onValueChange = { bmiViewModel.height.value = it },
            label = { Text(stringResource(id = R.string.height)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { bmiViewModel.calculateBMI() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.calculate))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (bmiViewModel.bmiResult.value.isNotEmpty()) {
            Text(
                text = "${stringResource(id = R.string.bmi_result)} ${bmiViewModel.bmiResult.value}",
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = bmiViewModel.imageResource.value),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}