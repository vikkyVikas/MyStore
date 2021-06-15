package com.example.mystore.ui.theme.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import com.example.mystore.R
import com.example.mystore.model.CollectionType
import com.example.mystore.model.Product
import com.example.mystore.model.ProductCollection
import com.example.mystore.model.products
import com.example.mystore.ui.theme.MyStoreTheme
import com.example.mystore.ui.theme.utils.mirroringIcon
import com.google.accompanist.coil.rememberCoilPainter
import java.security.KeyStore


private val HighlightCardWidth=170.dp
private val HighlightCardPadding =16.dp

// the card show  a gradient which spans 3 cards and scrolls with parallax.

private val gradientWidth

@Composable
get()= with(LocalDensity.current){
    (3 * HighlightCardWidth+ HighlightCardPadding).to.px())
}
@Composable
fun ProductCollection(
    productCollection: ProductCollection,
    onProductClick:(Long) ->Unit,
    modifier:Modifier =  Modifier,index:Int =0,
    highlight:Boolean=true

){
    Column(
        modifier=modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start)
        ) {
            Text(
                text = productCollection.name,
                style = MaterialTheme.typography.h6,
                color = MyStoreTheme.colors.brand,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = mirroringIcon(
                        ltrIcon=Icons.Outlined.ArrowForward,
                        rtlIcon=Icons.Outlined.ArrowBack
                    ),
                    tint = MyStoreTheme.colors.brand,
                    contentDescription = null
                )
            }

        }

        }
    }
}



