package com.tatayab.tatayab.checkout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020-2\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001H\u0016J\u0014\u0010\u00a2\u0001\u001a\u00030\u009e\u00012\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u0001H\u0002J\t\u0010\u00a5\u0001\u001a\u00020$H\u0002J\n\u0010\u00a6\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00a7\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00a8\u0001\u001a\u00030\u009e\u0001H\u0002J\u001e\u0010\u00a9\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f2\r\u0010\u00aa\u0001\u001a\b\u0012\u0004\u0012\u00020\r0>H\u0002J\u001e\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\r2\u000b\b\u0002\u0010\u00ac\u0001\u001a\u0004\u0018\u00010-H\u0002\u00a2\u0006\u0003\u0010\u00ad\u0001J\u001d\u0010\u00ae\u0001\u001a\u00030\u008c\u00012\u000b\b\u0002\u0010\u00ac\u0001\u001a\u0004\u0018\u00010-H\u0002\u00a2\u0006\u0003\u0010\u00af\u0001J\n\u0010\u00b0\u0001\u001a\u00030\u009e\u0001H\u0016J/\u0010\u00b1\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b3\u00010\u00b2\u00012\u0016\u0010\u00b4\u0001\u001a\u0011\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00b5\u0001H\u0002\u00a2\u0006\u0003\u0010\u00b6\u0001J\n\u0010\u00b7\u0001\u001a\u00030\u009e\u0001H\u0002J\t\u0010\u00b8\u0001\u001a\u00020-H\u0016J\u001c\u0010\u00b9\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00ba\u0001\u001a\u00020\b2\u0007\u0010\u00bb\u0001\u001a\u00020$H\u0002J\u0013\u0010\u00bc\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00bd\u0001\u001a\u00020@H\u0016J\u0014\u0010\u00be\u0001\u001a\u00030\u009e\u00012\b\u0010\u00bf\u0001\u001a\u00030\u00c0\u0001H\u0016J\u0016\u0010\u00c1\u0001\u001a\u00030\u009e\u00012\n\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00c3\u0001H\u0017J\u0013\u0010\u00c4\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00bd\u0001\u001a\u00020\bH\u0016J\n\u0010\u00c5\u0001\u001a\u00030\u009e\u0001H\u0016J\n\u0010\u00c6\u0001\u001a\u00030\u009e\u0001H\u0016J\u0013\u0010\u00c7\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00c8\u0001\u001a\u00020\bH\u0016J\u0013\u0010\u00c9\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00c8\u0001\u001a\u00020\bH\u0016J\u0014\u0010\u00ca\u0001\u001a\u00030\u009e\u00012\b\u0010\u00cb\u0001\u001a\u00030\u00c3\u0001H\u0016J\u0016\u0010\u00cc\u0001\u001a\u00030\u009e\u00012\n\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u00cd\u0001H\u0016J4\u0010\u00ce\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00cf\u0001\u001a\u00020\b2\u0007\u0010\u00d0\u0001\u001a\u00020\b2\u0016\u0010\u00d1\u0001\u001a\u0011\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00b5\u0001H\u0016J%\u0010\u00d2\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00d0\u0001\u001a\u00020\b2\u0007\u0010\u00a0\u0001\u001a\u00020\r2\u0007\u0010\u00d3\u0001\u001a\u00020-H\u0016J\n\u0010\u00d4\u0001\u001a\u00030\u009e\u0001H\u0016J8\u0010\u00d5\u0001\u001a\u00030\u009e\u00012\b\u0010\u00d6\u0001\u001a\u00030\u00d7\u00012\u0007\u0010\u00d0\u0001\u001a\u00020\b2\u0007\u0010\u00a0\u0001\u001a\u00020\r2\u0007\u0010\u00d8\u0001\u001a\u00020-2\u0007\u0010\u009f\u0001\u001a\u00020-H\u0016J \u0010\u00d9\u0001\u001a\u00030\u009e\u00012\b\u0010\u00da\u0001\u001a\u00030\u00db\u00012\n\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00c3\u0001H\u0017J\n\u0010\u00dc\u0001\u001a\u00030\u009e\u0001H\u0016J\n\u0010\u00dd\u0001\u001a\u00030\u009e\u0001H\u0002J\u001d\u0010\u00de\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00d3\u0001\u001a\u00020-2\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001H\u0016J\n\u0010\u00df\u0001\u001a\u00030\u009e\u0001H\u0002J.\u0010\u00e0\u0001\u001a\u00030\u009e\u00012\"\u0010\u00e1\u0001\u001a\u001d\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020-\u0012\u0005\u0012\u00030\u008c\u00010\u00e2\u00010\u00e2\u0001H\u0002J\n\u0010\u00e3\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00e4\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00e5\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00e6\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00e7\u0001\u001a\u00030\u009e\u0001H\u0002J5\u0010\u00e8\u0001\u001a\u00030\u009e\u00012\u0015\u0010\u00e9\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030\u00a4\u00010\u00e2\u00012\u0012\b\u0002\u0010\u00ea\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u00eb\u0001\u0018\u00010\fH\u0002J\n\u0010\u00ec\u0001\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010\u00ed\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00ee\u0001\u001a\u00020-H\u0002J\b\u0010\u00ef\u0001\u001a\u00030\u009e\u0001J\n\u0010\u00f0\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00f1\u0001\u001a\u00030\u009e\u0001H\u0002J\b\u0010\u00f2\u0001\u001a\u00030\u009e\u0001J\n\u0010\u00f3\u0001\u001a\u00030\u009e\u0001H\u0002J\u0019\u0010\u00f4\u0001\u001a\u00030\u009e\u00012\r\u0010\u00f5\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\n\u0010\u00f6\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00f7\u0001\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010\u00f8\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00bd\u0001\u001a\u00020@H\u0016J\u0013\u0010\u00f9\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00d0\u0001\u001a\u00020\bH\u0016J\n\u0010\u00fa\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010\u00fb\u0001\u001a\u00030\u009e\u0001H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001e\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00103\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00102\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001e\u00106\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00102\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\u001e\u00109\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00102\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u0010\u0010<\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\b0>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010?\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010>j\n\u0012\u0004\u0012\u00020@\u0018\u0001`AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER.\u0010F\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010>j\n\u0012\u0004\u0012\u00020@\u0018\u0001`AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER.\u0010I\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010>j\n\u0012\u0004\u0012\u00020@\u0018\u0001`AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER.\u0010L\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010>j\n\u0012\u0004\u0012\u00020@\u0018\u0001`AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010C\"\u0004\bN\u0010ER.\u0010O\u001a\u0016\u0012\u0004\u0012\u00020@\u0018\u00010>j\n\u0012\u0004\u0012\u00020@\u0018\u0001`AX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010C\"\u0004\bQ\u0010ER\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020WX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020WX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020WX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001e\u0010i\u001a\u00020j8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010o\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0014\"\u0004\bq\u0010\u0016R\u001c\u0010r\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0014\"\u0004\bt\u0010\u0016R\u001c\u0010u\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0014\"\u0004\bw\u0010\u0016R\u001c\u0010x\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0014\"\u0004\bz\u0010\u0016R\u0010\u0010{\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0081\u0001\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0014\"\u0005\b\u0083\u0001\u0010\u0016R\u001d\u0010\u0084\u0001\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0014\"\u0005\b\u0086\u0001\u0010\u0016R\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010@X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e\u00a2\u0006\u0005\n\u0003\u0010\u008d\u0001R\u0013\u0010\u008e\u0001\u001a\u0004\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u00102R\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0086.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R$\u0010\u0097\u0001\u001a\u00030\u0098\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001\u00a8\u0006\u00fc\u0001"}, d2 = {"Lcom/tatayab/tatayab/checkout/GiftOptionsFragment;", "Lcom/tatayab/tatayab/base/BaseFragment2;", "Lcom/tatayab/tatayab/listener/OnCartListener;", "Lcom/tatayab/tatayab/listener/OnUpdateAmountListener;", "Lcom/tatayab/tatayab/util/NavigationResult;", "Lcom/tatayab/tatayab/listener/OnGiftListener;", "()V", "amount", "", "cartAdapter", "Lcom/tatayab/tatayab/main/cart/CartAdapter2;", "cartProducts", "", "Lcom/tatayab/model/responses/CartOrderResponse;", "getCartProducts", "()Ljava/util/List;", "setCartProducts", "(Ljava/util/List;)V", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "category1", "getCategory1", "setCategory1", "category2", "getCategory2", "setCategory2", "category3", "getCategory3", "setCategory3", "category4", "getCategory4", "setCategory4", "comeFromDelete", "", "getComeFromDelete", "()Z", "setComeFromDelete", "(Z)V", "comeFromUpdate", "getComeFromUpdate", "setComeFromUpdate", "currentGiftItemId", "", "getCurrentGiftItemId", "()Ljava/lang/Integer;", "setCurrentGiftItemId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "currentGiftItemIdc", "getCurrentGiftItemIdc", "setCurrentGiftItemIdc", "currentSelectedWrapEntityId", "getCurrentSelectedWrapEntityId", "setCurrentSelectedWrapEntityId", "currentSelectedWrapId", "getCurrentSelectedWrapId", "setCurrentSelectedWrapId", "deliveryTime", "giftProductList", "Ljava/util/ArrayList;", "giftProductsList", "Lcom/tatayab/model/ProductX;", "Lkotlin/collections/ArrayList;", "getGiftProductsList", "()Ljava/util/ArrayList;", "setGiftProductsList", "(Ljava/util/ArrayList;)V", "giftProductsList1", "getGiftProductsList1", "setGiftProductsList1", "giftProductsList2", "getGiftProductsList2", "setGiftProductsList2", "giftProductsList3", "getGiftProductsList3", "setGiftProductsList3", "giftProductsList4", "getGiftProductsList4", "setGiftProductsList4", "knetData", "Lcom/tatayab/model/KnetData;", "listener", "Lcom/tatayab/tatayab/listener/OnHomeNavigationListener;", "mGiftAdapter", "Lcom/tatayab/tatayab/main/cart/GiftAdapter;", "mGiftAdapter1", "mGiftAdapter2", "Lcom/tatayab/tatayab/main/cart/GiftAdapter2;", "mGiftAdapter3", "mGiftAdapter4", "mGiftModelCached", "Lcom/tatayab/presentation/base/GiftModel;", "getMGiftModelCached", "()Lcom/tatayab/presentation/base/GiftModel;", "setMGiftModelCached", "(Lcom/tatayab/presentation/base/GiftModel;)V", "mainViewModel", "Lcom/tatayab/presentation/main/MainActivityViewModel;", "getMainViewModel", "()Lcom/tatayab/presentation/main/MainActivityViewModel;", "setMainViewModel", "(Lcom/tatayab/presentation/main/MainActivityViewModel;)V", "mainViewModelFactory", "Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "getMainViewModelFactory", "()Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;", "setMainViewModelFactory", "(Lcom/tatayab/presentation/main/MainActivityViewModelFactory$Factory;)V", "mcard_id", "getMcard_id", "setMcard_id", "mwrap_id", "getMwrap_id", "setMwrap_id", "nextSelectedGiftId", "getNextSelectedGiftId", "setNextSelectedGiftId", "nextSelectedGiftIdc", "getNextSelectedGiftIdc", "setNextSelectedGiftIdc", "oldSelectedGiftProductID", "oldSelectedGiftProductIDc", "orderId", "paymentSuccess", "productGistResponse", "Lcom/tatayab/model/responses/ProductsListResponse;", "productGraphID", "getProductGraphID", "setProductGraphID", "selectProductUIDConnectToGift", "getSelectProductUIDConnectToGift", "setSelectProductUIDConnectToGift", "selectedGiftProduct", "selectedGiftProductID", "selectedGiftProductIDc", "selectedGiftProductc", "subTotalPrice", "", "Ljava/lang/Float;", "totalCount", "totalUserOrders", "unSelectedProductID", "viewModel", "Lcom/tatayab/presentation/main/cart/CartFragmentViewModel;", "getViewModel", "()Lcom/tatayab/presentation/main/cart/CartFragmentViewModel;", "setViewModel", "(Lcom/tatayab/presentation/main/cart/CartFragmentViewModel;)V", "viewModelFactory", "Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;", "getViewModelFactory", "()Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;", "setViewModelFactory", "(Lcom/tatayab/presentation/main/cart/CartFragmentViewModelFactory$Factory;)V", "addToWishlist", "", "position", "product", "Lcom/tatayab/model/Product;", "checkGiftMessage", "cartResponse", "Lcom/tatayab/model/responses/GetOrdersFromCartResponse;", "checkGiftProductRequired", "checkNoticationPermission", "createCartForUser", "createCartForaGuest", "getCartProductPerCountry", "cartItemsList", "getGiftItemIfExist", "giftItemId", "(Ljava/lang/Integer;)Lcom/tatayab/model/responses/CartOrderResponse;", "getGiftItemPriceIfExist", "(Ljava/lang/Integer;)F", "getGiftOptions", "getOptions", "", "Lcom/tatayab/model/OptionsMap;", "selectedOptions", "", "(Ljava/util/Map;)[Lcom/tatayab/model/OptionsMap;", "intComponent", "layoutId", "notifyHomeWithChanges", "prductID", "newStatues", "onAddButtonClicked", "mProductX", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteButtonClicked", "onDestroy", "onDetach", "onGetButtonClicked", "mProductID", "onGetButtonClicked2", "onNavigationResult", "result", "onOptionsClicked", "Lcom/tatayab/model/MapValueXXX;", "onProductClicked", "cartId", "productId", "options", "onProductDelete", "index", "onResume", "onUpdateAmount", "operationType", "Lcom/tatayab/presentation/OperationType;", "value", "onViewCreated", "view", "Landroid/view/View;", "openGiftView", "openMainGiftView", "removeFromWishlist", "removeGiftItemDataFromLocal", "setTotal", "pair", "Lkotlin/Pair;", "setupGiftList", "setupGiftList1", "setupGiftList2", "setupGiftList3", "setupGiftList4", "setupWithData", "cartContentResponse", "second", "Lcom/tatayab/model/CartMap;", "shareCartWithFriends", "showCartContent", "visibility", "showLoginDialog", "showLoginScreen", "showNotificationPermissionDialog", "slideMainGiftViewToAbove", "startAppRateLogin", "trackCartByInsider", "products", "trackOrderByAdjust", "trackOrderByInsider", "updateGift", "updateGiftId", "updateGiftText", "updateGiftViewLayout", "app_developmentDebug"})
public final class GiftOptionsFragment extends com.tatayab.tatayab.base.BaseFragment2 implements com.tatayab.tatayab.listener.OnCartListener, com.tatayab.tatayab.listener.OnUpdateAmountListener, com.tatayab.tatayab.util.NavigationResult, com.tatayab.tatayab.listener.OnGiftListener {
    public com.tatayab.presentation.main.MainActivityViewModel mainViewModel;
    public com.tatayab.presentation.main.cart.CartFragmentViewModel viewModel;
    private java.util.ArrayList<java.lang.String> giftProductList;
    private com.tatayab.model.ProductX selectedGiftProduct;
    private java.lang.String selectedGiftProductID;
    private java.lang.String oldSelectedGiftProductID = "";
    private com.tatayab.model.ProductX selectedGiftProductc;
    private java.lang.String selectedGiftProductIDc;
    private java.lang.String oldSelectedGiftProductIDc = "";
    private java.lang.String unSelectedProductID;
    private com.tatayab.model.responses.ProductsListResponse productGistResponse;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.tatayab.model.responses.CartOrderResponse> cartProducts;
    private boolean comeFromDelete = false;
    private boolean comeFromUpdate = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String productGraphID = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String selectProductUIDConnectToGift = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer currentGiftItemId = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer currentGiftItemIdc = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer currentSelectedWrapEntityId = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer currentSelectedWrapId = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.String nextSelectedGiftId = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.String nextSelectedGiftIdc = "";
    @org.jetbrains.annotations.Nullable
    private com.tatayab.presentation.base.GiftModel mGiftModelCached;
    @org.jetbrains.annotations.Nullable
    private java.lang.String mwrap_id = "";
    @org.jetbrains.annotations.Nullable
    private java.lang.String mcard_id = "";
    @javax.inject.Inject
    public com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory viewModelFactory;
    @javax.inject.Inject
    public com.tatayab.presentation.main.MainActivityViewModelFactory.Factory mainViewModelFactory;
    private com.tatayab.tatayab.listener.OnHomeNavigationListener listener;
    private java.lang.String orderId;
    private boolean paymentSuccess = false;
    private java.lang.String totalUserOrders;
    private java.lang.String amount = "";
    private java.lang.String deliveryTime;
    private com.tatayab.model.KnetData knetData;
    private java.lang.Integer totalCount;
    private java.lang.Float subTotalPrice;
    private com.tatayab.tatayab.main.cart.CartAdapter2 cartAdapter;
    private com.tatayab.tatayab.main.cart.GiftAdapter mGiftAdapter;
    private com.tatayab.tatayab.main.cart.GiftAdapter mGiftAdapter1;
    private com.tatayab.tatayab.main.cart.GiftAdapter2 mGiftAdapter2;
    private com.tatayab.tatayab.main.cart.GiftAdapter mGiftAdapter3;
    private com.tatayab.tatayab.main.cart.GiftAdapter mGiftAdapter4;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.ProductX> giftProductsList;
    @org.jetbrains.annotations.Nullable
    private java.lang.String category = "";
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.ProductX> giftProductsList1;
    @org.jetbrains.annotations.Nullable
    private java.lang.String category1 = "";
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.ProductX> giftProductsList2;
    @org.jetbrains.annotations.Nullable
    private java.lang.String category2 = "";
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.ProductX> giftProductsList3;
    @org.jetbrains.annotations.Nullable
    private java.lang.String category3 = "";
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.tatayab.model.ProductX> giftProductsList4;
    @org.jetbrains.annotations.Nullable
    private java.lang.String category4 = "";
    private java.util.HashMap _$_findViewCache;
    
    public GiftOptionsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.cart.CartFragmentViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.CartFragmentViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.tatayab.model.responses.CartOrderResponse> getCartProducts() {
        return null;
    }
    
    public final void setCartProducts(@org.jetbrains.annotations.Nullable
    java.util.List<com.tatayab.model.responses.CartOrderResponse> p0) {
    }
    
    public final boolean getComeFromDelete() {
        return false;
    }
    
    public final void setComeFromDelete(boolean p0) {
    }
    
    public final boolean getComeFromUpdate() {
        return false;
    }
    
    public final void setComeFromUpdate(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProductGraphID() {
        return null;
    }
    
    public final void setProductGraphID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectProductUIDConnectToGift() {
        return null;
    }
    
    public final void setSelectProductUIDConnectToGift(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCurrentGiftItemId() {
        return null;
    }
    
    public final void setCurrentGiftItemId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCurrentGiftItemIdc() {
        return null;
    }
    
    public final void setCurrentGiftItemIdc(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCurrentSelectedWrapEntityId() {
        return null;
    }
    
    public final void setCurrentSelectedWrapEntityId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getCurrentSelectedWrapId() {
        return null;
    }
    
    public final void setCurrentSelectedWrapId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNextSelectedGiftId() {
        return null;
    }
    
    public final void setNextSelectedGiftId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNextSelectedGiftIdc() {
        return null;
    }
    
    public final void setNextSelectedGiftIdc(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.tatayab.presentation.base.GiftModel getMGiftModelCached() {
        return null;
    }
    
    public final void setMGiftModelCached(@org.jetbrains.annotations.Nullable
    com.tatayab.presentation.base.GiftModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMwrap_id() {
        return null;
    }
    
    public final void setMwrap_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMcard_id() {
        return null;
    }
    
    public final void setMcard_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.cart.CartFragmentViewModelFactory.Factory p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.tatayab.presentation.main.MainActivityViewModelFactory.Factory getMainViewModelFactory() {
        return null;
    }
    
    public final void setMainViewModelFactory(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.main.MainActivityViewModelFactory.Factory p0) {
    }
    
    @java.lang.Override
    public int layoutId() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void removeGiftItemDataFromLocal() {
    }
    
    private final void updateGiftViewLayout() {
    }
    
    private final void startAppRateLogin() {
    }
    
    private final void checkGiftMessage(com.tatayab.model.responses.GetOrdersFromCartResponse cartResponse) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final void trackOrderByInsider() {
    }
    
    private final void trackCartByInsider(java.util.List<com.tatayab.model.responses.CartOrderResponse> products) {
    }
    
    private final void showCartContent(int visibility) {
    }
    
    @android.annotation.SuppressLint(value = {"StringFormatInvalid"})
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateGiftText() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.ProductX> getGiftProductsList() {
        return null;
    }
    
    public final void setGiftProductsList(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    private final void setupGiftList() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.ProductX> getGiftProductsList1() {
        return null;
    }
    
    public final void setGiftProductsList1(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategory1() {
        return null;
    }
    
    public final void setCategory1(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    private final void setupGiftList1() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.ProductX> getGiftProductsList2() {
        return null;
    }
    
    public final void setGiftProductsList2(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategory2() {
        return null;
    }
    
    public final void setCategory2(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    private final void setupGiftList2() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.ProductX> getGiftProductsList3() {
        return null;
    }
    
    public final void setGiftProductsList3(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategory3() {
        return null;
    }
    
    public final void setCategory3(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    private final void setupGiftList3() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.tatayab.model.ProductX> getGiftProductsList4() {
        return null;
    }
    
    public final void setGiftProductsList4(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.tatayab.model.ProductX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCategory4() {
        return null;
    }
    
    public final void setCategory4(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    private final void setupGiftList4() {
    }
    
    private final void checkNoticationPermission() {
    }
    
    private final void showNotificationPermissionDialog() {
    }
    
    private final void trackOrderByAdjust() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onNavigationResult(@org.jetbrains.annotations.NotNull
    android.os.Bundle result) {
    }
    
    private final void setupWithData(kotlin.Pair<java.lang.String, com.tatayab.model.responses.GetOrdersFromCartResponse> cartContentResponse, java.util.List<com.tatayab.model.CartMap> second) {
    }
    
    private final java.util.List<com.tatayab.model.responses.CartOrderResponse> getCartProductPerCountry(java.util.ArrayList<com.tatayab.model.responses.CartOrderResponse> cartItemsList) {
        return null;
    }
    
    private final com.tatayab.model.responses.CartOrderResponse getGiftItemIfExist(java.lang.Integer giftItemId) {
        return null;
    }
    
    private final float getGiftItemPriceIfExist(java.lang.Integer giftItemId) {
        return 0.0F;
    }
    
    private final void setTotal(kotlin.Pair<java.lang.String, kotlin.Pair<java.lang.Integer, java.lang.Float>> pair) {
    }
    
    private final void intComponent() {
    }
    
    private final boolean checkGiftProductRequired() {
        return false;
    }
    
    private final void openMainGiftView() {
    }
    
    @java.lang.Override
    public void onProductDelete(@org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CartOrderResponse product, int index) {
    }
    
    @java.lang.Override
    public void onProductClicked(@org.jetbrains.annotations.NotNull
    java.lang.String cartId, @org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.String> options) {
    }
    
    @java.lang.Override
    public void onOptionsClicked(@org.jetbrains.annotations.Nullable
    com.tatayab.model.MapValueXXX product) {
    }
    
    private final com.tatayab.model.OptionsMap[] getOptions(java.util.Map<java.lang.String, java.lang.String> selectedOptions) {
        return null;
    }
    
    @java.lang.Override
    public void addToWishlist(int position, @org.jetbrains.annotations.NotNull
    com.tatayab.model.Product product) {
    }
    
    @java.lang.Override
    public void removeFromWishlist(int index, @org.jetbrains.annotations.NotNull
    com.tatayab.model.Product product) {
    }
    
    @java.lang.Override
    public void updateGiftId(@org.jetbrains.annotations.NotNull
    java.lang.String productId) {
    }
    
    @java.lang.Override
    public void openGiftView() {
    }
    
    @java.lang.Override
    public void onUpdateAmount(@org.jetbrains.annotations.NotNull
    com.tatayab.presentation.OperationType operationType, @org.jetbrains.annotations.NotNull
    java.lang.String productId, @org.jetbrains.annotations.NotNull
    com.tatayab.model.responses.CartOrderResponse product, int value, int position) {
    }
    
    @java.lang.Override
    public void getGiftOptions() {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onDetach() {
    }
    
    private final void notifyHomeWithChanges(java.lang.String prductID, boolean newStatues) {
    }
    
    @java.lang.Override
    public void onAddButtonClicked(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX mProductX) {
    }
    
    @java.lang.Override
    public void updateGift(@org.jetbrains.annotations.NotNull
    com.tatayab.model.ProductX mProductX) {
    }
    
    @java.lang.Override
    public void onDeleteButtonClicked(@org.jetbrains.annotations.NotNull
    java.lang.String mProductX) {
    }
    
    @java.lang.Override
    public void onGetButtonClicked(@org.jetbrains.annotations.NotNull
    java.lang.String mProductID) {
    }
    
    @java.lang.Override
    public void onGetButtonClicked2(@org.jetbrains.annotations.NotNull
    java.lang.String mProductID) {
    }
    
    public final void slideMainGiftViewToAbove() {
    }
    
    private final void shareCartWithFriends() {
    }
    
    private final void createCartForUser() {
    }
    
    private final void createCartForaGuest() {
    }
    
    public final void showLoginDialog() {
    }
    
    private final void showLoginScreen() {
    }
}