package com.example.myamplifyapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.api.graphql.model.ModelQuery
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Game
import com.amplifyframework.ui.authenticator.ui.Authenticator
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.http.LoggingInterceptor
import com.apollographql.apollo3.network.ws.AppSyncWsProtocol
import com.apollographql.apollo3.network.ws.WebSocketNetworkTransport
import com.example.appsync.MySubscription
import com.example.appsync.OnCreateActivitySubscription
import com.example.appsync.QueryGamesQuery
import com.example.appsync.UpdateAwayScoreMutation
import com.example.appsync.UpdateHomeScoreMutation
import com.example.appsync.adapter.OnCreateActivitySubscription_ResponseAdapter
import com.example.myamplifyapp.ui.theme.MyAmplifyAppTheme
import kotlinx.coroutines.launch
import java.util.Date
import java.util.TimeZone
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    private val gameList = mutableStateListOf<Game>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAmplifyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Authenticator { _ ->
                        Scaffold(
                            floatingActionButton = {
                                FloatingActionButton(
                                    onClick = {
//                                              this.refreshItems()
//                                        val date = Date()
//                                        val offsetMillis = TimeZone.getDefault().getOffset(date.time).toLong()
//                                        val offsetSeconds = TimeUnit.MILLISECONDS.toSeconds(offsetMillis).toInt()
//                                        val temporalDateTime = Temporal.DateTime(date, offsetSeconds)
//                                        val game = Game.builder()
//                                            .homeScore(0)
//                                            .awayScore(0)
//                                            .gameAwayTeamId("")
//                                            .gameHomeTeamId("")
//                                            .location("")
//                                            .content("")
//                                            .build()
//
//                                        Amplify.API.mutate(
//                                            ModelMutation.create(game),
//                                            {
//                                                Log.i("MyAmplifyApp", "Added Todo with id: ${it.data.id}")
//                                                gameList.add(game)
//                                            },
//                                            { Log.e("MyAmplifyApp", "Create failed", it) }
//                                        )
                                    },
                                ) {
                                    Icon(Icons.Filled.Add, "Add a random todo.")
                                }
                            }
                        ) {
                            Column(modifier = Modifier.padding(it)) {
                                Button(onClick = {
                                    Amplify.Auth.signOut {  }
                                }) {
                                    Text(text = "Sign Out")
                                }

                                GameList()
                                Text(text = "Activities", fontWeight = FontWeight.Bold)
                                ActivityList()
                            }
                        }
                    }
                }
            }
        }
    }
}

val authorization = mapOf(
    "host" to "524yirzyevfx3nkpdxl2rdb42q.appsync-api.us-east-1.amazonaws.com",
    "x-api-key" to "da2-oh7xcvy57ffatj27ryyihigcnu"
)

val url = AppSyncWsProtocol.buildUrl(
    baseUrl = "https://524yirzyevfx3nkpdxl2rdb42q.appsync-realtime-api.us-east-1.amazonaws.com/",
    authorization = authorization
)

val apolloClient = ApolloClient.Builder()
    .serverUrl("https://524yirzyevfx3nkpdxl2rdb42q.appsync-api.us-east-1.amazonaws.com/graphql")
    .addHttpInterceptor(AuthorizationInterceptor())
    .addHttpInterceptor(LoggingInterceptor())
    .subscriptionNetworkTransport(WebSocketNetworkTransport.Builder().serverUrl(url).protocol(AppSyncWsProtocol.Factory(authorization = authorization)).build())
    .build()

@Composable
fun ActivityList() {
    var activityList by remember { mutableStateOf(emptyList<OnCreateActivitySubscription.OnCreateActivity>()) }
    LaunchedEffect(Unit) {
       val sub = apolloClient.subscription(OnCreateActivitySubscription()).toFlow().collect {
           val item = it.data?.onCreateActivity
           Log.d("ONACTIVITYCREATE", it.toString())
           Log.d("ONACTIVITYCREATE", it.errors.toString())
           Log.d("ONACTIVITYCREATE", it.data.toString())
           if (item != null) {
               activityList = activityList + item
           }
           Log.d("ONACTIVITYCREATE", activityList.toString())
       }
    }

    LazyColumn {
        items(activityList) { activity ->
            // Render your activity item here
            Text(text = activity.event.toString())
        }
    }
}

@Composable
fun GameList() {
    var gameList by remember { mutableStateOf(emptyList<QueryGamesQuery.Item>()) }
    LaunchedEffect(Unit) {
        Log.i("TESTING", "TESTING ATTENTION PLEAS")
        val response = apolloClient.query(QueryGamesQuery()).execute()
        gameList = response.data?.listGames?.items?.filterNotNull() ?: emptyList()
        response.data?.listGames?.items?.forEach {
            Log.d("LaunchList", "Success ${it?.awayTeam?.name} vs. ${it?.homeTeam?.name}")
        }
        val sub = apolloClient.subscription(MySubscription()).toFlow().collect {
            Log.d("LaunchList", "${it.data?.onUpdateGame?.awayScore} vs. ${it?.data?.onUpdateGame?.homeScore}")
            it.data?.onUpdateGame?.let { updatedGame ->
                gameList = gameList.map { game ->
                    Log.d("LaunchList", "Updated")
                    if (game.id == updatedGame.id) {
                        game.copy(
                            awayScore = updatedGame.awayScore,
                            homeScore = updatedGame.homeScore
                        )
                    } else {
                        game
                    }
                }
            }
        }
    }

    LazyColumn {
        gameList.forEach { game ->
            item {
                GameItem(game = game)
            }
        }
    }
}

@Composable
fun GameItem(game: QueryGamesQuery.Item) {
    val coroutineScope = rememberCoroutineScope()

    ListItem(
        headlineContent = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = game.awayTeam?.name ?: "",
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${game.awayScore}",
                        fontSize = 48.sp,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable {
                                coroutineScope.launch {
                                    apolloClient
                                        .mutation(
                                            UpdateAwayScoreMutation(
                                                id = game.id,
                                                awayScore = game.awayScore + 1
                                            )
                                        )
                                        .execute()
                                }
                            }

                    )
                }
                Text(
                    text = "vs.",
                    fontWeight = FontWeight.Bold, // Make "vs." text bold
                    modifier = Modifier.padding(vertical = 4.dp) // Add padding for better appearance
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = game.homeTeam?.name ?: "",
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${game.homeScore}",
                        fontSize = 48.sp,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .clickable {
                                coroutineScope.launch {
                                    apolloClient
                                        .mutation(
                                            UpdateHomeScoreMutation(
                                                id = game.id,
                                                homeScore = game.homeScore + 1
                                            )
                                        )
                                        .execute()
                                }
                            }
                    )
                }
            }
        }
    )
}

