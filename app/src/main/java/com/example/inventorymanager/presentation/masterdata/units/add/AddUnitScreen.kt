package com.example.inventorymanager.presentation.masterdata.units.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.units.UnitsViewModel


@Composable
fun AddUnitScreen(
    viewModel: UnitsViewModel = hiltViewModel(),
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
                    viewModel.addUnit(unit)
                },
                navigateBack = navigateBack
            )
        }
    )
}