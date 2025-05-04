#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<tuple<int, int, int>> j = {{1,2,100},{2,1,19},{3,2,27},{4,1,25},{5,3,15}};
    sort(j.begin(), j.end(), [](auto &a, auto &b){ return get<2>(a) > get<2>(b); });

    int d = 0; for (auto &x : j) d = max(d, get<1>(x));
    vector<int> s(d + 1, -1); int p = 0;

    for (auto &[id, dl, pr] : j)
        for (int i = dl; i; i--)
            if (s[i] == -1) { s[i] = id; p += pr; break; }

    for (int i = 1; i <= d; i++) if (s[i] != -1) cout << s[i] << " ";
}
