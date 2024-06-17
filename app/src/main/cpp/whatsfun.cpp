#include <jni.h>
#include <string>
#include <sstream>
#include <iomanip>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_shroomish_1flag_1checker_wee_ed(JNIEnv* env, jobject /* this */, jstring input) {
    const char* inputCStr = env->GetStringUTFChars(input, nullptr);
    std::string g = std::string(inputCStr);
    env->ReleaseStringUTFChars(input, inputCStr);

    std::stringstream z;
    for (char c : g) {
        uint8_t k = static_cast<uint8_t>(c);
        uint8_t u = k;

        for(int y=0; y < 3; y++ ){
            u = (u << 1) | (u >> 7);
        }


        z << std::hex << std::uppercase << std::setw(2) << std::setfill('0') << static_cast<int>(u);
    }

    std::string q = z.str();

    return env->NewStringUTF(q.c_str());
}
