#include <bits/stdc++.h>
using namespace std;

int find(int u, vector<int> &p) {
    return p[u] < 0 ? u : p[u] = find(p[u], p);
}

bool unite(int u, int v, vector<int> &p) {
    u = find(u, p); v = find(v, p);
    if (u == v) return false;
    if (p[u] > p[v]) swap(u, v);
    p[u] += p[v]; p[v] = u;
    return true;
}

int main() {
    int n, m; cin >> n >> m;
    vector<tuple<int, int, int>> edges(m);
    for (auto &[w, u, v] : edges) cin >> u >> v >> w;
    sort(edges.begin(), edges.end());

    vector<int> parent(n, -1);
    int cost = 0;
    for (auto [w, u, v] : edges)
        if (unite(u, v, parent)) cost += w;
    cout << "MST cost: " << cost << "\n";
}
