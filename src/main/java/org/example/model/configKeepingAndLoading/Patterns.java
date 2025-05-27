package org.example.model.configKeepingAndLoading;

public enum Patterns {
    L_Shape(
            new int[][] {
                    {1, 0, 0, 0},
                    {0, 1, 2, 2},
                    {1, 1, 1, 0},
                    {0, 0, 1, 2}
            },
            new int[][] {
                    {2, 2, 1, 0},
                    {1, 1, 1, 0},
                    {2, 1, 0, 0},
                    {1, 0, 0, 0}
            }
    ),
    S_Shape(
            new int[][] {
                    {0, 1, 1, 2},
                    {1, 1, 0, 0},
                    {0, 1, 1, 2},
                    {1, 1, 0, 0}
            },
            new int[][] {
                    {1, 1, 0, 0},
                    {2, 1, 1, 0},
                    {1, 1, 0, 0},
                    {2, 1, 1, 0}
            }
    ),
    Z_Shape(
            new int[][] {
                    {2, 1, 1, 0},
                    {1, 1, 0, 0},
                    {2, 1, 1, 0},
                    {1, 1, 0, 0}
            },
            new int[][] {
                    {1, 1, 0, 0},
                    {0, 1, 1, 2},
                    {1, 1, 0, 0},
                    {0, 1, 1, 2}
            }
    ),
    Rev_L_Shape(
            new int[][] {
                    {0, 1, 1, 1},
                    {2, 2, 1, 0},
                    {0, 0, 0, 1},
                    {2, 1, 0, 0}
            },
            new int[][] {
                    {2, 2, 1, 0},
                    {1, 0, 0, 0},
                    {2, 1, 0, 0},
                    {1, 1, 1, 0}
            }
    ),
    T_Shape(
            new int[][] {
                    {1, 2, 1, 0},
                    {0, 0, 0, 1},
                    {2, 1, 0, 1},
                    {1, 1, 1, 0}
            },
            new int[][] {
                    {1, 0, 0, 0},
                    {2, 1, 0, 1},
                    {1, 1, 1, 0},
                    {2, 1, 0, 1}
            }
    ),
    Square_Shape(
            new int[][] {
                    {1, 0, 1, 0},
                    {1, 0, 1, 0},
                    {1, 0, 1, 0},
                    {1, 0, 1, 0}
            },
            new int[][] {
                    {1, 1, 0, 0},
                    {1, 1, 0, 0},
                    {1, 1, 0, 0},
                    {1, 1, 0, 0}
            }
    ),
    I_Shape(
            new int[][] {
                    {0, 0, 0, 0},
                    {0, 1, 2, 3},
                    {0, 0, 0, 0},
                    {0, 1, 2, 3}
            },
            new int[][] {
                    {3, 2, 1, 0},
                    {0, 0, 0, 0},
                    {3, 2, 1, 0},
                    {0, 0, 0, 0}
            }
    );

    private final int[][] patternX;
    private final int[][] patternY;

    Patterns(int[][] patternX, int[][] patternY) {
        this.patternX = patternX;
        this.patternY = patternY;
    }

    public int[][] getPatternX() {
        return patternX;
    }

    public int[][] getPatternY() {
        return patternY;
    }
}

