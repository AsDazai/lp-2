#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

void dijkstra(int n, vector<vector<pair<int, int>>> &g, int src) {

    vector<int> d(n, INF); d[src] = 0;

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    
    pq.push({0, src});

    while (!pq.empty()) {
        auto [du, u] = pq.top(); pq.pop();
        if (du > d[u]) continue;

        for (auto [v, w] : g[u])
            if (d[u] + w < d[v]) pq.push({d[v] = d[u] + w, v});
    }

    for (int i = 0; i < n; i++) cout << "To " << i << ": " << d[i] << "\n";

}


int main() {
    vector<vector<pair<int, int>>> g(5);
    
    g[0] = {{1,10},{2,3}}, g[1] = {{2,1},{3,2}}, g[2] = {{1,4},{3,8},{4,2}}, g[3] = {{4,7}}, g[4] = {{3,9}};
    
    dijkstra(5, g, 0);
}
