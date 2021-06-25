package com.example.mystore.ui.theme.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonElevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mystore.ui.theme.MyStoreTheme


@Composable
fun MyStoreCard(
    modifier: Modifier=Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    color: Color = MyStoreTheme.colors.uiBackground,
    contentColor:Color = MyStoreTheme.colors.textPrimary,
    border:BorderStroke?= null,
    elevation: Dp = 4.dp,
    content:@Composable () -> Unit
)
{
    MyStoreSurface(
    modifier = modifier,
    shape = shape,
    color = color,
    contentColor = contentColor,
    elevation = elevation,
    border = border,
    content = content
)
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun CardPreview() {
    MyStoreTheme {
        MyStoreCard {
            Text(text = "Demo", modifier = Modifier.padding(16.dp))
        }
    }
}