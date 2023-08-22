#include <iostream>
using namespace std;

void fcfs(int p[], int bt[], int n)
{
    int tat[3];
    int ct[3];
    int wt[3];
    float totalwt = 0;
    float totaltat;

    ct[0] = bt[0];

    for (int i = 1; i < n; i++)
    {
        ct[i] = bt[i] + ct[i - 1];
    }
    for (int i = 0; i < n; i++)
    {
        tat[i] = ct[i] - 0;
    }

    for (int i = 0; i < n; i++)
    {
        wt[i] = tat[i] - bt[0];
    }

    for (int i = 0; i < n; i++)
    {
        totalwt = totalwt + wt[i];
    }
    cout << totalwt / 3;
}
int main()
{
    int processor[] = {1, 2, 3};
    int burst_time[] = {3, 4, 6};
    int n = 3;

    fcfs(processor, burst_time, n);
    return 0;
}