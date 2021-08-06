package com.example.mystore.ui.theme.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.example.mystore.ui.theme.MyStoreTheme


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyStoreScaffold(
    modifier: Modifier = Modifier,
    scaffoldState:ScaffoldState= rememberScaffoldState(),
    topBar:@Composable (() -> Unit)={},
    bottomBar:@Composable (() -> Unit)={},
    snackbarHost:@Composable (SnackbarHostState)->Unit={SnackbarHost(it)},
    floatingActionButton:@Composable (() -> Unit)={},
    floatingActionButtonPosition:FabPosition= FabPosition.End,
    isFloatingActionButtonDocked:Boolean= false,
    drawerContent: @Composable (ColumnScope.()->Unit)?=null,
    drawerShape: Shape =MaterialTheme.shapes.large,
    drawerElevation: Dp =  DrawerDefaults.Elevation,
    drawerBackgroundColor: Color =MyStoreTheme.colors.uiBackground,
    drawerContentColor: Color= MyStoreTheme.colors.textSecondary,
    drawerScrimColor:Color = MyStoreTheme.colors.uiBorder,
    backgroundColor:Color=MyStoreTheme.colors.uiBackground,
    contentColor:Color=MyStoreTheme.colors.textSecondary,
    content:@Composable (PaddingValues) -> Unit,
    )
{
    Scaffold(
        modifier=modifier,
        scaffoldState=scaffoldState,
        topBar=topBar,
        bottomBar=bottomBar,
        snackbarHost=snackbarHost,
        floatingActionButton=floatingActionButton,
        floatingActionButtonPosition=floatingActionButtonPosition,
        isFloatingActionButtonDocked=isFloatingActionButtonDocked,
        drawerContent=drawerContent,
        drawerShape=drawerShape,
        drawerElevation = drawerElevation,
        drawerBackgroundColor = drawerBackgroundColor,
        drawerContentColor = drawerContentColor,
        drawerScrimColor = drawerScrimColor,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        content = content
    )
}
