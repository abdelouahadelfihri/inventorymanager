package com.example.inventorymanager.presentation.masterdata.units.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.units.MeasurementUnitsViewModel
import com.example.inventorymanager.presentation.masterdata.units.add.components.AddUnitContent
import com.example.inventorymanager.presentation.masterdata.units.add.components.AddUnitTopBar


@Composable
fun AddUnitScreen(
    viewModel: MeasurementUnitsViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AddUnitTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddUnitContent(
                padding = padding,
                unit = viewModel.unit,
                addUnit = { unit ->
                    viewModel.addUnit(unit) // Call it, but make sure this function itself returns Unit
                },
                navigateBack = navigateBack
            )
        }
    )
}