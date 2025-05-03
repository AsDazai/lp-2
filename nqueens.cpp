#include <bits/stdc++.h>
using namespace std;

bool isSafe(vector<int>& board, int row, int col, int n) {
    for (int i = 0; i < row; i++)
        if (board[i] == col || board[i] - i == col - row || board[i] + i == col + row)
            return false;
    return true;
}

bool solveNQueens(vector<int>& board, int row, int n) {
    if (row == n) { 
        for (int i = 0; i < n; i++) cout << board[i] + 1 << " "; 
        cout << endl;
        return true;
    }
    bool res = false;
    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col, n)) {
            board[row] = col;
            res = solveNQueens(board, row + 1, n) || res;
        }
    }
    return res;
}

int main() {
    int n = 8;  // You can change n to solve for different board sizes
    vector<int> board(n, -1);
    if (!solveNQueens(board, 0, n)) cout << "No solution\n";
    return 0;
}
