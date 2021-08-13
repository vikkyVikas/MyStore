package com.example.mystore.ui.components

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
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


private val HighlightCardWidth=170.dp
private val HighlightCardPadding =16.dp

// the card show  a gradient which spans 3 cards and scrolls with parallax.

private val gradientWidth

@Composable
get()= with(LocalDensity.current){
    (3 * (HighlightCardWidth+ HighlightCardPadding).toPx())
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
        if(highlight && productCollection.type==CollectionType.Highlight){
            Highlightedproducts(index,productCollection.products,onProductClick)
        }else{
            Products(productCollection.products,onProductClick)
        }
        }
    }
@Composable
private fun Highlightedproducts(
    index:Int,
    products:List<Product>,
    onProductClick:(Long)->Unit,
    modifier:Modifier=Modifier
){
    val scroll= rememberScrollState(0)
    val gradient = when((index/2)%2){
        0-> MyStoreTheme.colors.gradient6_1
        else-> MyStoreTheme.colors.gradient6_2
    }
    val gradientWidth= with(LocalDensity.current){
        (6*(HighlightCardWidth+ HighlightCardPadding).toPx())

    }
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 24.dp,end = 24.dp)
    ) {
        itemsIndexed(products){
            index, product->
            HighlightProductItem(
            product,
            onProductClick,
            index,
            gradient,
            gradientWidth,
            scroll.value
        )
        }
    }
}
@Composable
private fun Products(
    products: List<Product>,
    onProductClick: (Long) -> Unit,
    modifier:Modifier=Modifier
){

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start=12.dp,end=12.dp)
    ) {
        items(products){product->
            ProductItem(product,onProductClick)
        }

    }
}
@Composable
fun ProductItem(
    product:Product,
    onProductClick: (Long) -> Unit,
    modifier: Modifier=Modifier
) {
    MyStoreSurface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(start = 4.dp, end = 4.dp, bottom = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = { onProductClick(product.id) })
                .padding(8.dp)
        ) {
            ProductImage(imageUrl =product.imageUrl,elevation = 4.dp,contentDescription = null,modifier = Modifier.size(120.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.subtitle1,
                color = MyStoreTheme.colors.textSecondary,
                modifier = Modifier.padding(top = 8.dp)

            )
        }
    }
}


@Composable
fun HighlightProductItem(
    product:Product,
    onProductClick: (Long) -> Unit,
    index:Int,
    gradient:List<Color>,
    gradientWidth:Float,
    scroll:Int,
    modifier: Modifier=Modifier
) {
    val left = index * with(LocalDensity.current) {
        (HighlightCardWidth + HighlightCardPadding).toPx()
    }
    MyStoreCard(
        modifier = modifier
            .size(
                width = 170.dp,
                height = 250.dp
            )
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { onProductClick(product.id) })
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
            )
            {
                val gradientOffset = left - (scroll / 3f)
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .offsetGradientBackground(gradient, gradientWidth, gradientOffset)
                )
                ProductImage(
                    imageUrl = product.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.BottomCenter)
                )

            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = MyStoreTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = product.tagline,
                style = MaterialTheme.typography.body1,
                color = MyStoreTheme.colors.textHelp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}




@Composable
fun ProductImage(
    imageUrl:String,
    contentDescription:String?,
    modifier: Modifier=Modifier,
    elevation:Dp = 0.dp
){
    MyStoreSurface (
        color=Color.LightGray,
        elevation=elevation,
        shape= RectangleShape,
        modifier = modifier
            ){
            Image(painter = rememberCoilPainter(request = imageUrl,previewPlaceholder = R.drawable.placeholder), contentDescription = contentDescription, modifier=Modifier.fillMaxSize(),contentScale= ContentScale.Crop )

    }
}

@Preview("default")
@Preview("dark theme", uiMode = UI_MODE_NIGHT_YES)
@Preview("large font",fontScale = 2f)
@Composable
fun ProductCardPreview()
{
    MyStoreTheme {
        val product= products.first()
        HighlightProductItem(
            product = product,
            onProductClick = { /*TODO*/ },
            index =0 ,
            gradient = MyStoreTheme.colors.gradient6_1,
            gradientWidth = gradientWidth,
            scroll =0
        )
        
    }
}




