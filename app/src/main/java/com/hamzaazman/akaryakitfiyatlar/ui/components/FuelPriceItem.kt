package com.hamzaazman.akaryakitfiyatlar.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hamzaazman.akaryakitfiyatlar.data.model.FuelPriceInfo
import java.util.Locale

@Composable
fun FuelPriceItem(
    priceInfo: FuelPriceInfo,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit = { /* Handle item click */ }
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        onClick = {
            onItemClick()
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = priceInfo.ilce,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Column(
                horizontalAlignment = Alignment.End
            ) {
                priceInfo.benzin?.let {
                    Text(
                        text = "Benzin: ${String.format(Locale.getDefault(), "%.2f TL", it)}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                priceInfo.mazot?.let {
                    Text(
                        text = "Mazot: ${String.format(Locale.getDefault(), "%.2f TL", it)}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                val lpgText = priceInfo.lpg?.let {
                    String.format(Locale.getDefault(), "%.2f TL", it)
                } ?: "N/A"
                Text(
                    text = "LPG: $lpgText",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}