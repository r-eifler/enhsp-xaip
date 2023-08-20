package com.hstairs.ppmajal.search;

import java.util.Comparator;

public class TieBreaker implements Comparator<SearchNode> {

    final SearchEngine.TieBreaking tb;
    public boolean bfs;

    public TieBreaker(SearchEngine.TieBreaking tb) {
        super();
        this.tb = tb;
        bfs = true;
    }

    public TieBreaker(SearchEngine.TieBreaking tieBreaking, boolean b) {
        this(tieBreaking);
        bfs = b;
    }

    @Override
    public int compare(SearchNode o1, SearchNode o2) {
        final SearchNode other = o2;
        final SearchNode a = o1;
        if (a.f == other.f) {
            switch (tb) {
                case HIGHERG:
                    //                out.println(this.gValue);
                    if (a.gValue < other.gValue)//goal is farer
                    {
                        return +1;
                    } else if (a.gValue > other.gValue) //goal is closer
                    {
                        return -1;
                    } else {
                        return 0;
                    }
                case LOWERG:
                    if (a.gValue < other.gValue)//goal is farer
                    {
                        return -1;
                    } else if (a.gValue > other.gValue) //goal is closer
                    {
                        return +1;
                    } else {
                        return 0;
                    }
                case ARBITRARY:
                    return 0;
                default:
                    throw new RuntimeException("This shouldn't happen. Wrong tie breaking");
            }
        }
        if (bfs) {
            if (a.f <= other.f) {
                return -1;
            } else {
                return 1;
            }
        } else//dfs
        {
            if (a.f <= other.f) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
