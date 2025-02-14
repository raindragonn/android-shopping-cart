package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.ProductRepositoryImpl
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme


@Composable
internal fun ProductListScreen(
    productList: List<Product>,
    onTopBarButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProductListTopAppBar(
                onClickButton = onTopBarButtonClick
            )
        },
        content = { innerPadding ->
            ProductListContent(
                productList = productList,
                modifier = Modifier.padding(innerPadding)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            productList = ProductRepositoryImpl.getProductList(),
            onTopBarButtonClick = {}
        )
    }
}
