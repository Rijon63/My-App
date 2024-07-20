package com.example.noteapp.databinding;
import com.example.noteapp.R;
import com.example.noteapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentQuizBindingImpl extends FragmentQuizBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.question_number, 1);
        sViewsWithIds.put(R.id.question_card, 2);
        sViewsWithIds.put(R.id.question_text, 3);
        sViewsWithIds.put(R.id.answers_group, 4);
        sViewsWithIds.put(R.id.answer1, 5);
        sViewsWithIds.put(R.id.answer2, 6);
        sViewsWithIds.put(R.id.answer3, 7);
        sViewsWithIds.put(R.id.answer4, 8);
        sViewsWithIds.put(R.id.previous_button, 9);
        sViewsWithIds.put(R.id.next_button, 10);
        sViewsWithIds.put(R.id.submit_button, 11);
        sViewsWithIds.put(R.id.result_text, 12);
        sViewsWithIds.put(R.id.play_again_button, 13);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentQuizBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentQuizBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RadioButton) bindings[5]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.RadioButton) bindings[8]
            , (android.widget.RadioGroup) bindings[4]
            , (android.widget.Button) bindings[10]
            , (android.widget.Button) bindings[13]
            , (android.widget.Button) bindings[9]
            , (androidx.cardview.widget.CardView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[12]
            , (android.widget.Button) bindings[11]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.quizViewModel == variableId) {
            setQuizViewModel((com.example.noteapp.ui.viewmodel.QuizViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setQuizViewModel(@Nullable com.example.noteapp.ui.viewmodel.QuizViewModel QuizViewModel) {
        this.mQuizViewModel = QuizViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): quizViewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}