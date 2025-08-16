package com.example.inventorymanager.presentation.masterdata.units.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.units.UnitsViewModel
import com.example.inventorymanager.presentation.masterdata.units.details.components.UpdateUnitContent
import com.example.inventorymanager.presentation.masterdata.units.details.components.UpdateUnitTopBar


@Composable
fun UpdateUnitScreen(
    viewModel: UnitsViewModel = hiltViewModel(),
    unitId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getUnit(unitId)
    }
    Scaffold(
        topBar = {
            UpdateUnitTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateUnitContent(
                padding = padding,
                unit = viewModel.unit,
                updateUnit = { unit ->
                    viewModel.updateUnit(unit)
                },
                deleteUnit = { unitId ->
                    viewModel.deleteUnit(unitId)
                },
                navigateBack = navigateBack
            )
        }
    )
}