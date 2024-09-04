class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        const long long M=60001, lb=-30000;
        unordered_set<long long> obSet;
        obSet.reserve(obstacles.size());
        for(auto& ob: obstacles){
            long long x=ob[0]-lb, y=ob[1]-lb;
            obSet.insert(x*M+y);
        }

        const int dir[4][2]={{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int x=0, y=0, dx=0, dy=1, face=0, maxD2=0;
        for(int c: commands){
            switch(c){
                case -2: face=(face+1)%4; dx=dir[face][0]; dy=dir[face][1]; break;
                case -1: face=(face+3)%4; dx=dir[face][0]; dy=dir[face][1]; break;
                default:
                    for(int i=0; i<c; i++){
                        x+=dx, y+=dy;
                        if (obSet.count((x-lb)*M+y-lb)) {
                            x-=dx;
                            y-=dy;
                            break;
                        }
                        maxD2=max(maxD2, x*x+y*y);
                    }
            }
        }
        return maxD2;
    }
};